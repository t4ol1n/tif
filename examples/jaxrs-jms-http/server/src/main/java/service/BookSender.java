/**
 * Copyright (C) 2010 Talend Inc. - www.talend.com
 */
package service;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;

import common.Book;
import common.BookListener;

/**
 * Sends a book to a the camel endpoint "direct:bookListener".
 * 
 * To see how this message is further processed look for a camel route that
 * starts with from("direct:bookListener") in the camel context.
 * 
 * We could also have a producerTemplate in BookStoreImpl. By keeping it
 * in a separate class we avoid mixing business logic and routing.
 */
public class BookSender implements BookListener {
    @Produce(uri="direct:bookListener")
    private ProducerTemplate producer;

    @Override
    public void onBook(Book book) {
        producer.sendBody(book);
    }

}