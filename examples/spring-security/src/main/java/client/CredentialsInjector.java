package client;

import javax.xml.ws.BindingProvider;

public class CredentialsInjector {
    
    public static void inject(Object serviceProxy, String username, String password) {
        BindingProvider bp = (BindingProvider)serviceProxy;
        bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
        bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, password);
    }
}
