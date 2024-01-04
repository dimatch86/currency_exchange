package ru.skillbox.currency.exchange.dto;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Getter
@ToString
public class XmlCurrencyDto {

    private String id;
    private Long isoNumCode;
    private String isoLetterCode;
    private Long nominal;
    private String name;
    private String value;
    private String vunitRate;

    @XmlAttribute(name = "ID")
    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "NumCode")
    public void setIsoNumCode(Long isoNumCode) {
        this.isoNumCode = isoNumCode;
    }

    @XmlElement(name = "CharCode")
    public void setIsoLetterCode(String isoLetterCode) {
        this.isoLetterCode = isoLetterCode;
    }

    @XmlElement(name = "Nominal")
    public void setNominal(Long nominal) {
        this.nominal = nominal;
    }

    @XmlElement(name = "Name")
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "Value")
    public void setValue(String value) {
        this.value = value;
    }
    @XmlElement(name = "VunitRate")
    public void setVunitRate(String vunitRate) {
        this.vunitRate = vunitRate;
    }
}
