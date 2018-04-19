package com.jiangjian.study.java.advanced.jaxb.marshal;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

public class MyValidationEventHandler implements ValidationEventHandler {
    @Override
    public boolean handleEvent(ValidationEvent event) {
        System.out.println("hah" + event.getMessage());
        return false;
    }
}
