package com.jiangjian.study.java.advanced.jaxb.marshal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.time.LocalDate;
import java.util.Arrays;

public class MarshalCountiesDemo {
    public static void main(String[] args) {
        Country china = new Country();
        china.setName("china");
        china.setCapital("beijing");
        china.setContinent("Asian");
        china.setFoundation(LocalDate.of(1949, 10, 1));
        china.setImportance(99);
        china.setPopulation(1300000000);

        Country japan = new Country();
        japan.setName("japan");
        japan.setCapital("tokyo");
        japan.setContinent("Asian");
        japan.setFoundation(LocalDate.of(1900, 10, 1));
        japan.setImportance(98);
        japan.setPopulation(200000000);

        Countries countries = new Countries();
        countries.setCountries(Arrays.asList(china, japan));
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class);
            Marshaller jaxbMashaller = jaxbContext.createMarshaller();
            jaxbMashaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMashaller.marshal(countries, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
