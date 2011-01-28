package service;

import org.apache.camel.Consume;

import common.Book;

/**
 * Shows how to attach to a camel route using pojo messaging.
 *  
 * Receives a message from jms, deserializes with 
 * JAXB and sends the Book object to the java method receiveBook
 */
public class BookReceiver {
    
    @Consume(uri="jms://test.books")
    public void receiveBook(Book book) {
        System.out.println("Received book over jms: " + book);
    }

}
