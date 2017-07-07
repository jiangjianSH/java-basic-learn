package com.jiangjian.study.java.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/24.
 */
public class QueryXml {
    public void query() throws ParserConfigurationException, SAXException,
            IOException, XPathExpressionException {
        // standard for reading an XML file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        XPathExpression expr = null;
        builder = factory.newDocumentBuilder();
        doc = builder.parse("person.xml");

        // create an XPathFactory
        XPathFactory xFactory = XPathFactory.newInstance();

        // create an XPath object
        XPath xpath = xFactory.newXPath();

        // compile the XPath expression
        expr = xpath.compile("//person[firstname='Lars']/lastname/text()");
        // run the query and get a nodeset
        Object result = expr.evaluate(doc, XPathConstants.NODESET);

        // cast the result to a DOM NodeList
        NodeList nodes = (NodeList) result;
        for (int i=0; i<nodes.getLength();i++){
            System.out.println(nodes.item(i).getNodeValue());
        }

        // new XPath expression to get the number of people with name Lars
        expr = xpath.compile("count(//person[firstname='Lars'])");
        // run the query and get the number of nodes
        Double number = (Double) expr.evaluate(doc, XPathConstants.NUMBER);
        System.out.println("Number of objects " +number);

        // do we have more than 2 people with name Lars?
        expr = xpath.compile("count(//person[firstname='Lars']) >2");
        // run the query and get the number of nodes
        Boolean check = (Boolean) expr.evaluate(doc, XPathConstants.BOOLEAN);
        System.out.println(check);
    }

    public static void main(String[] args) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
        QueryXml process = new QueryXml();
        process.query();
    }
}
