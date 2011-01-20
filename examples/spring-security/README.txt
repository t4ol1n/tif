TIF Spring Security Example
===========================

This example shows how to leverage Spring Security to secure camel routes to CXF
JAX-WS and JAX-RS endpoints. 

The server part runs standalone, in a servlet container or in OSGi. Spring security is configured to 
require basic auth for all requests. The credentials are hardcoded for this simple example.  A camel 
http servlet serves all requests. In the camel context there is one route from the sevlet to a JAX-WS
endpoint and one route to a JAX-RS endpoint. Both endpoints authorize users on the method level using
JSR-250 annotations (@RolesAllowed).
 
The example can be run using Maven.

You will need to compile this example first:
  mvn clean install

To run the example, you need to start up the server by typing
  mvn jetty:run

To stop the server hit ctrl + c

