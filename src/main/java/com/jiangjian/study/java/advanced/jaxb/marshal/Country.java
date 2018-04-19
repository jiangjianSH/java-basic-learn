package com.jiangjian.study.java.advanced.jaxb.marshal;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.Date;

@XmlType(propOrder = {"name", "capital", "foundation", "continent", "population", "create"})
@XmlRootElement(name = "Country")
public class Country {
    private int population;

    private String name;

    private String capital;

    private int importance;

    private LocalDate foundation;

    private String continent;

    private Date create;

    public int getPopulation() {
        return population;
    }

    @XmlElement(name = "population")
    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    @XmlElement(name = "capital")
    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getImportance() {
        return importance;
    }

    @XmlAttribute(name = "importance", required = true)
    public void setImportance(int importance) {
        this.importance = importance;
    }

    public LocalDate getFoundation() {
        return foundation;
    }

    @XmlElement(name = "foundation")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setFoundation(LocalDate foundation) {
        this.foundation = foundation;
    }

    public String getContinent() {
        return continent;
    }

    @XmlElement(name = "continent")
    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Date getCreate() {
        return create;
    }

    @XmlElement(name = "create")
    public void setCreate(Date create) {
        this.create = create;
    }

    @Override
    public String toString() {
        return "Country{" +
                "population=" + population +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", importance=" + importance +
                ", foundation='" + foundation + '\'' +
                ", continent='" + continent + '\'' +
                ", create=" + create +
                '}';
    }
}
