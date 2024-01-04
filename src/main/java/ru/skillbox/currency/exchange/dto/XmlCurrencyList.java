package ru.skillbox.currency.exchange.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ValCurs")
public class XmlCurrencyList {

    private List<XmlCurrencyDto> xmlCurrencyDtos;

    @XmlElement(name = "Valute")
    public List<XmlCurrencyDto> getXmlCurrencyDtos() {
        return xmlCurrencyDtos;
    }

    public void setXmlCurrencyDtos(List<XmlCurrencyDto> xmlCurrencyDtos) {
        this.xmlCurrencyDtos = xmlCurrencyDtos;
    }
}
