package ru.skillbox.currency.exchange.mapper;

import ru.skillbox.currency.exchange.dto.CurrencyDto;
import ru.skillbox.currency.exchange.dto.CurrencyListResponse;
import ru.skillbox.currency.exchange.entity.Currency;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CurrencyMapperDelegate implements CurrencyMapper {

    @Override
    public List<CurrencyDto> currencyListToResponseList(List<Currency> currencyList) {

        if (currencyList == null) {
            return new ArrayList<>();
        }
        return currencyList.stream()
                .map(currency -> CurrencyDto.builder()
                        .name(currency.getName())
                        .value(currency.getValue())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public CurrencyListResponse currencyListToCurrencyListResponse(List<Currency> currencyList) {
        return new CurrencyListResponse(currencyListToResponseList(currencyList));
    }
}
