package com.jiangjian.study.java.advanced.jaxb.marshal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.time.LocalDate;
import java.util.Date;

public class MarshalCountryDemo {
    public static void main(String[] args) {
        Country country = new Country();
        country.setName("china");
        country.setCapital("beijing");
        country.setContinent("Asian");
        country.setCreate(new Date());
        country.setFoundation(LocalDate.of(1949, 10, 1));
        country.setImportance(99);
        country.setPopulation(1300000000);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
            Marshaller jaxbMashaller = jaxbContext.createMarshaller();
            jaxbMashaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMashaller.marshal(country, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
