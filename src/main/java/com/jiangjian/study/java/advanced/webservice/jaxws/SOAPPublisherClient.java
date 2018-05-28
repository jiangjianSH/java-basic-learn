package com.jiangjian.study.java.advanced.webservice.jaxws;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class SOAPPublisherClient {
    public static void main(String[] args) throws MalformedURLException {
        URL wsdlURL = new URL("http://localhost:8888/ws/person?wsdl");

        QName qName = new QName("http://jaxws.webservice.advanced.java.study.jiangjian.com/", "PersonServiceImplService");

        Service service = Service.create(wsdlURL, qName);

        PersonService ps = service.getPort(PersonService.class);

        Person p1 = new Person(); p1.setName("Pankaj"); p1.setId(1); p1.setAge(30);
        Person p2 = new Person(); p2.setName("Meghna"); p2.setId(2); p2.setAge(25);

        //add person
        System.out.println("Add Person Status="+ps.addPerson(p1));
        System.out.println("Add Person Status="+ps.addPerson(p2));


        //get person
        System.out.println(ps.getPerson(1));


        System.out.println(Arrays.asList(ps.getAllPersons()));

        //delete person
        System.out.println("status: " + ps.deletePerson(2));

        System.out.println(Arrays.asList(ps.getAllPersons()));
    }
}
