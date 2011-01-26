package client;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;

import common.Book;
import common.BookList;
import common.BookStore;

/**
 * CXF does not provide a JAX RS client API that can handle JMS transport. So we implement the BookStore
 * interface ourself. So the client code stays the same. Camel helps us by providing methods that make
 * coding the client very easy in most cases.
 * 
 */
public class BookStoreJmsClient implements BookStore {
    private static final String JMS_URI = "jms://test.bookStore";
    @EndpointInject
    ProducerTemplate producer;
    
    private Map<String, Object> getRestHeaders(String method, String path) {
        Map<String, Object> headers = new HashMap<String, Object>();
        headers.put(Exchange.HTTP_METHOD, method);
        headers.put(Exchange.HTTP_PATH, path);
        return headers;
    }

    @Override
    public Book getBook(Long id) {
        return producer.requestBodyAndHeaders(JMS_URI, null, getRestHeaders("GET", "/" + id), Book.class);
    }

    @Override
    public Response addBook(Book book) {
        return producer.requestBodyAndHeaders(JMS_URI, book, getRestHeaders("POST", "/"), Response.class);
    }

    @Override
    public void oneWayRequest(Book book) throws Exception {
    }

    @Override
    public BookList listBooks() {
        Map<String, Object> headers = new HashMap<String, Object>();
        headers.put(Exchange.HTTP_METHOD, "GET");
        headers.put(Exchange.HTTP_PATH, "/");
        return producer.requestBodyAndHeaders(JMS_URI, null, getRestHeaders("GET", "/"), BookList.class);
    }

}
