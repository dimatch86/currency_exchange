package ru.skillbox.currency.exchange.dto;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Setter
@XmlRootElement(name = "ValCurs")
public class XmlCurrencyList {

    private List<XmlCurrencyDto> xmlCurrencyDtos;

    @XmlElement(name = "Valute")
    public List<XmlCurrencyDto> getXmlCurrencyDtos() {
        return xmlCurrencyDtos;
    }
}
