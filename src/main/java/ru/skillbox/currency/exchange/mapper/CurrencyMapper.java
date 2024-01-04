package ru.skillbox.currency.exchange.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import ru.skillbox.currency.exchange.dto.CurrencyDto;
import ru.skillbox.currency.exchange.dto.CurrencyListResponse;
import ru.skillbox.currency.exchange.dto.XmlCurrencyList;
import ru.skillbox.currency.exchange.entity.Currency;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
@DecoratedWith(CurrencyMapperDelegate.class)
public interface CurrencyMapper {

    CurrencyDto convertToDto(Currency currency);

    Currency convertToEntity(CurrencyDto currencyDto);
    List<CurrencyDto> currencyListToResponseList(List<Currency> currencyList);

    default CurrencyListResponse currencyListToCurrencyListResponse(List<Currency> currencyList) {
        CurrencyListResponse response = new CurrencyListResponse();
        response.setCurrencies(currencyListToResponseList(currencyList));
        return response;
    }

    default List<Currency> xmlCurrencyListToCurrencyList(XmlCurrencyList xmlCurrencyList) {
        return new ArrayList<>();
    }
}
