package service;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;

import common.Book;
import common.BookListener;

public class BookSender implements BookListener {
    @Produce(uri="direct:bookListener")
    private ProducerTemplate producer;

    @Override
    public void onBook(Book book) {
        producer.sendBody(book);
    }

}
