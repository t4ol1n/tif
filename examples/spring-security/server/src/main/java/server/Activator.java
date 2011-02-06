package server;

import java.util.Dictionary;
import java.util.Hashtable;

import javax.servlet.Servlet;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;

public class Activator implements BundleActivator {
    static Log log = LogFactory.getLog(Activator.class);
    private ServiceReference httpServiceRef;
    private static boolean registerService;

    @Override
    public void start(BundleContext bc) throws Exception {
        log.info("Activator start");
        registerServlet(bc);
        log.info("Activator ok");
    }

    @Override
    public void stop(BundleContext arg0) throws Exception {
        // TODO Auto-generated method stub

    }

    protected void registerServlet(BundleContext bundleContext) throws Exception {
        httpServiceRef = bundleContext.getServiceReference(HttpService.class.getName());

        if (httpServiceRef != null && !registerService) {
            final HttpService httpService = (HttpService)bundleContext.getService(httpServiceRef);
            if (httpService != null) {
                // create a default context to share between registrations
                final HttpContext httpContext = httpService.createDefaultHttpContext();
                // register the hello world servlet
                final Dictionary<String, String> initParams = new Hashtable<String, String>();
                initParams.put("matchOnUriPrefix", "true");
                initParams.put("servlet-name", "camelServlet");
                httpService.registerServlet("/camel/services", // alias
                                            (Servlet)new CamelHttpTransportServlet(), // register servlet
                                            initParams, // init params
                                            httpContext // http context
                    );
                registerService = true;
            }
        }
    }

}
