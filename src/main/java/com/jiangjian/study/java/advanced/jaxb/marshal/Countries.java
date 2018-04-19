package com.jiangjian.study.java.advanced.jaxb.marshal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Countries {
    List<Country> countries;

    @XmlElement(name = "country")
    @XmlElementWrapper(name = "countries")
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<Country> getCountries() {
        return countries;
    }
}
