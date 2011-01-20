/**
 * Copyright (C) 2010 Talend Inc. - www.talend.com
 */
package server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Starts a jetty server for the project.
 * This is mainly to run and debug the tests in you ide.
 * For production you would either build a war file or deploy
 * the project to an osgi runtime like karaf
 */
public class JettyStarter {

    public static void main(String[] args) throws Exception {
    	System.setProperty("org.apache.cxf.Logger", "org.apache.cxf.common.logging.Log4jLogger");
        new JettyStarter().run();
    }

    private void run() throws Exception {
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
        Server server = new org.eclipse.jetty.server.Server(9090);

        WebAppContext webappcontext = new WebAppContext();
        webappcontext.setContextPath("/");
        webappcontext.setWar("src/main/webapp");
        webappcontext.setClassLoader(this.getClass().getClassLoader());
        server.setHandler( webappcontext);

        server.start();
    }

}
