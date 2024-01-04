package ru.skillbox.currency.exchange.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.stereotype.Service;
import ru.skillbox.currency.exchange.client.CurrencyClient;
import ru.skillbox.currency.exchange.dto.CurrencyDto;
import ru.skillbox.currency.exchange.dto.CurrencyListResponse;
import ru.skillbox.currency.exchange.entity.Currency;
import ru.skillbox.currency.exchange.exception.CurrencyNotFoundException;
import ru.skillbox.currency.exchange.mapper.CurrencyMapper;
import ru.skillbox.currency.exchange.repository.CurrencyRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyMapper mapper;
    private final CurrencyRepository repository;
    private final CurrencyClient currencyClient;

    public CurrencyDto getById(Long id) {
        log.info("CurrencyService method getById executed");
        Currency currency = repository.findById(id).orElseThrow(() -> new RuntimeException("Currency not found with id: " + id));
        return mapper.convertToDto(currency);
    }

    public Double convertValue(Long value, Long numCode) {
        log.info("CurrencyService method convertValue executed");
        Currency currency = repository.findByIsoNumCode(numCode)
                .orElseThrow(() -> new CurrencyNotFoundException(MessageFormatter.format("Currency with numCode {} not found", numCode).getMessage()));
        return value * currency.getValue();
    }

    public CurrencyDto create(CurrencyDto dto) {
        log.info("CurrencyService method create executed");
        return  mapper.convertToDto(repository.save(mapper.convertToEntity(dto)));
    }

    public CurrencyListResponse getAllCurrencies() {
        return mapper.currencyListToCurrencyListResponse(repository.findAll());
    }

    public void updateAllCurrencies() {
        List<Currency> currenciesForDb = new ArrayList<>();
        List<Currency> currenciesFromXml = mapper.xmlCurrencyListToCurrencyList(currencyClient.getXmlCurrencyList());
        currenciesFromXml.forEach(currency -> repository.findByIsoNumCode(currency.getIsoNumCode())
                .ifPresentOrElse(currencyForUpdate -> {
                    currencyForUpdate.setValue(currency.getValue());
                    currencyForUpdate.setIsoCharCode(currency.getIsoCharCode());
                    currenciesForDb.add(currencyForUpdate);
                },
                        () -> currenciesForDb.add(currency)));
        repository.saveAll(currenciesForDb);
    }
}
