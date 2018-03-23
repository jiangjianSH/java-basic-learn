package com.jiangjian.study.java.xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BuildDocumentDemo {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        InputStream inputStream = new FileInputStream("src/main/resources/com/jiangjian/study/java/xml/config.xml");
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(inputStream);

        Element root = document.getDocumentElement();

        System.out.println("Root tag name: " + root.getTagName());

        NodeList rootChildren =root.getChildNodes();
        for(int i = 0; i < rootChildren.getLength(); i++) {
            Node childNode = rootChildren.item(i);

            System.out.println("Child Node Instance Type: " + childNode.getClass().getCanonicalName());
            System.out.println(childNode.getNodeName() + "=" + childNode.getTextContent());

            //output node attribute
            NamedNodeMap childNodeAttributes = childNode.getAttributes();
            if(childNodeAttributes != null && childNodeAttributes.getLength() > 0) {
                System.out.println("Attributes: [");
                for(int j = 0; j < childNodeAttributes.getLength(); j++) {
                    System.out.println(childNodeAttributes.item(j).getNodeName() + "=" + childNodeAttributes.item(j).getNodeValue());
                }
                System.out.println("]");
            }
        }
        inputStream.close();
    }
}
