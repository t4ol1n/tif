/**
 * Copyright (C) 2010 Talend Inc. - www.talend.com
 */
package client;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import common.Book;
import common.BookList;
import common.BookStore;


public class BookStoreClientMain {

    public void useBookStore(BookStore bookStore) {
        Book book = bookStore.getBook(123L);
        System.out.println(book);
        bookStore.addBook(new Book("The Lord of the Rings", 22353L));
        Book book2 = bookStore.getBook(22353L);
        System.out.println(book2);
        BookList books = bookStore.listBooks();
        System.out.println(books.getBook());
    }
    
    /**
     * At the moment it is not possible to use the jax rs client API over jms
     * so we build the messages by hand in the camel route
     */
    
    public static void main (String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("client.xml");
        BookStoreClientMain client = new BookStoreClientMain();
        BookStore bookStoreJmsClient = context.getBean("bookStoreJmsClient", BookStore.class);
        client.useBookStore(bookStoreJmsClient);
        
        // TODO We should get this working with HTTP over camel transport 
        // "camel://direct:bookStoreHttp"
        
        BookStore bookStoreHttp = 
            JAXRSClientFactory.create("http://localhost:9002/bookstore", BookStore.class);
        client.useBookStore(bookStoreHttp);
        context.close();
    }
}
