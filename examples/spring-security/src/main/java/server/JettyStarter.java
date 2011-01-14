package server;

import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.security.core.context.SecurityContextHolder;


public class JettyStarter {

    public static void main(String[] args) throws Exception {
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
