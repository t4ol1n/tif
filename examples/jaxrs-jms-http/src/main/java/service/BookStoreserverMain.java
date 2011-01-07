package service;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookStoreserverMain {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/beans.xml");
        System.in.read();
        context.close();
    }

}
