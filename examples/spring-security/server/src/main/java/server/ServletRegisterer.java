package server;

import java.util.Dictionary;
import java.util.Hashtable;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.Lifecycle;
import org.springframework.web.bind.annotation.InitBinder;

import org.junit.Assert;

public class ServletRegisterer implements InitializingBean {
    String alias;
    String name;
    HttpServlet servlet;
    HttpService httpService;
    
    public void setHttpService(HttpService httpService) {
        this.httpService = httpService;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setServlet(HttpServlet servlet) {
        this.servlet = servlet;
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        final HttpContext httpContext = httpService.createDefaultHttpContext();
        final Dictionary<String, String> initParams = new Hashtable<String, String>();
        initParams.put("matchOnUriPrefix", "true");
        initParams.put("servlet-name", "camelServlet");
        
        httpService.registerServlet(alias, servlet, initParams, httpContext);
    }
    
}
