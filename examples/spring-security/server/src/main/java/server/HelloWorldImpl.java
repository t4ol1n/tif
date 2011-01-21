/**
 * Copyright (C) 2010 Talend Inc. - www.talend.com
 */
package server;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.security.RolesAllowed;

import common.HelloWorld;
import common.User;
import common.UserImpl;

public class HelloWorldImpl implements HelloWorld {	
    Map<Integer, User> users = new LinkedHashMap<Integer, User>();
    
    public HelloWorldImpl() {
    	users.put(1, new UserImpl("TestUser"));
    }

    @RolesAllowed("ROLE_USER")
    public String sayHi(String text) {
        return "Hello " + text;
    }

    @RolesAllowed("ROLE_USER")
    public String sayHiToUser(User user) {
        users.put(users.size() + 1, user);
        return "Hello " + user.getName();
    }

    @RolesAllowed("ROLE_ADMIN")
    public Map<Integer, User> getUsers() {
        return users;
    }

}
