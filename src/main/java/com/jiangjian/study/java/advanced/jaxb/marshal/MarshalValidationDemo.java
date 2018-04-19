package com.jiangjian.study.java.advanced.jaxb.marshal;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.time.LocalDate;
import java.util.Date;

public class MarshalValidationDemo {
    public static void main(String[] args) throws SAXException {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI );
        Schema schema = sf.newSchema(new File("src\\main\\java\\com\\jiangjian\\study\\java\\advanced\\jaxb\\marshal\\country.xsd"));

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
            jaxbMashaller.setSchema(schema);
            jaxbMashaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMashaller.setEventHandler(new MyValidationEventHandler());
            jaxbMashaller.marshal(country, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
