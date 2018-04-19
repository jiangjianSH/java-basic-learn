package com.jiangjian.study.java.advanced.jaxb.marshal;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnMashalCountryDemo {
    private static String content = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<Country importance=\"99\">\n" +
            "    <name>china</name>\n" +
            "    <capital>beijing</capital>\n" +
            "    <foundation>1949-10-01</foundation>\n" +
            "    <continent>Asian</continent>\n" +
            "    <population>1300000000</population>\n" +
            "    <create>2018-04-19T10:55:16.936+08:00</create>\n" +
            "</Country>";

    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            ByteInputStream is = new ByteInputStream();
            is.setBuf(content.getBytes());
            Country country = (Country) unmarshaller.unmarshal(is);
            System.out.println(country);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
