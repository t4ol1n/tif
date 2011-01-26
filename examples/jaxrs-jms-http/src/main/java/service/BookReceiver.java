package service;

import org.apache.camel.Consume;

import common.Book;

/**
 * Shows how to attach to a camel route using pojo messaging
 */
public class BookReceiver {
    
    @Consume(uri="jms://test.books")
    public void receiveBook(Book book) {
        System.out.println("Received book over jms: " + book);
    }

}
