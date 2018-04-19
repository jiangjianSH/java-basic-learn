package com.jiangjian.study.java.advanced.jaxb.marshal;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class UnMarshValidationDemo {
    public static void main(String[] args) throws SAXException, JAXBException {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI );
        Schema schema = sf.newSchema(new File("src\\main\\java\\com\\jiangjian\\study\\java\\advanced\\jaxb\\marshal\\country.xsd"));
        Validator validator = schema.newValidator();
        validator.setErrorHandler(new MyErrorHandler());

        Country country = new Country();
        country.setName("china");
        country.setCapital("beijing");
        country.setContinent("Asian");
        country.setCreate(new Date());
        country.setFoundation(LocalDate.of(1949, 10, 1));
        country.setImportance(99);
        country.setPopulation(1300000000);

        JAXBContext context = JAXBContext.newInstance(Country.class);
        JAXBSource source = new JAXBSource(context, country);

        try {
            validator.validate(source);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
