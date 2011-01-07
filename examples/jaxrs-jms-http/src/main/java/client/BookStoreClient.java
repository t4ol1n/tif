package client;

import common.Book;
import common.BookStore;

import org.apache.camel.Consume;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;


public class BookStoreClient {

    public void run() {
        BookStore bookStore = 
            JAXRSClientFactory.create("http://localhost:9002/bookstore", BookStore.class);
        Book book = bookStore.getBook(123L);
        System.out.println(book);
        bookStore.addBook(new Book("The Lord of the Rings", 22353L));
        Book book2 = bookStore.getBook(22353L);
        System.out.println(book2);
    }
    
    public static void main (String[] args) throws Exception {
        new BookStoreClient().run();
    }
}
