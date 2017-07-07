package com.jiangjian.study.java.advanced.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/25.
 */
public class BookMain {
    private static final String BOOKSTORE_XML = "./bookstore-jaxb.xml";

    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList<>();

        // create books
        Book book1 = new Book();
        book1.setIsbn("978-0060554736");
        book1.setName("The Game");
        book1.setAuthor("Neil Strauss");
        book1.setPublisher("Harpercollins");
        bookList.add(book1);

        Book book2 = new Book();
        book2.setIsbn("978-3832180577");
        book2.setName("Feuchtgebiete");
        book2.setAuthor("Charlotte Roche");
        book2.setPublisher("Dumont Buchverlag");
        bookList.add(book2);

        // create bookstore, assigning book
        Bookstore bookstore = new Bookstore();
        bookstore.setName("Fraport Bookstore");
        bookstore.setLocation("Frankfurt Airport");
        bookstore.setBookList(bookList);

        try {
            JAXBContext context = JAXBContext.newInstance(Bookstore.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(bookstore, System.out);
            m.marshal(bookstore, new File(BOOKSTORE_XML));

            //
            System.out.println("read from file");
            Unmarshaller um = context.createUnmarshaller();
            bookstore = (Bookstore) um.unmarshal(new FileReader(BOOKSTORE_XML));
            for(Book book : bookstore.getBookList()) {
                System.out.println(book);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
