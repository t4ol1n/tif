/**
 * Copyright (C) 2010 Talend Inc. - www.talend.com
 */
package client;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import talend.tif.examples.jaxrsjmshttp.common.BookStore;


/**
 * <p>
 * Starter for the book store client.
 * </p>
 * <p>
 * Shows how to run the book store client using a proxy to the service that calls
 * the service using JMS and HTTP.
 * </p>
 */
public class BookStoreClientMain {
    
    public static void main (String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("client.xml");
        BookStoreClient client = new BookStoreClient();
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
