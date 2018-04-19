package com.jiangjian.study.java.advanced.jaxb.marshal;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MyErrorHandler implements ErrorHandler {
    @Override
    public void warning(SAXParseException exception) throws SAXException {
        System.out.println("warning: " + exception.getLocalizedMessage());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        System.out.println("error: " + exception.getLocalizedMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        System.out.println("error: " + exception.getLocalizedMessage());
    }
}
