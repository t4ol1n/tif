package server;

import javax.annotation.security.RolesAllowed;

import org.apache.camel.converter.HasAnnotation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
public class ServerBean {
    @RolesAllowed("ROLE_ADMIN")
    public String serve(String request) {
        return "Test";
    }
}
