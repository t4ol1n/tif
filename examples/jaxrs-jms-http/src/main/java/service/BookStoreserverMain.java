/**
 * Copyright (C) 2010 Talend Inc. - www.talend.com
 */
package service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookStoreServerMain {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/beans.xml");
        System.in.read();
        context.close();
    }

}
