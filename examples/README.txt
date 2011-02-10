TIF Examples
===============================================================================

jaxrs-jms-http
   Publishing and using the same jaxrs implmentation using http and jms

jaxws-jms
   Publishing and using a CXF JAX-WS service using SOAP/JMS

spring-security
   Securing Camel routes and CXF endpoints using spring security

blueprint
    Deploy Camel routes using a simple blueprint descriptor


Getting Help
===============================================================================

If the examples don�t work as expected or you have problem adapting them to your projects do not hesitate 
to ask for help.

Talend provides free support on the CXF and Camel mailing lists, irc channels and on the Talend Forums.
Additionally you can request support from the professional services team.

Apache Support Channels (each site has links to mailing list, irc and issue tracker):
http://camel.apache.org
http://karaf.apache.org
http://cxf.apache.org


Talend Support Channels:
http://www.talendforge.org/forum/
http://www.talend.com/professional-support/support.php
https://jira.sopera.de/browse/IF

Please use the contact channel that is most apropriate for your problem. General problems that apply 
to the Apache projects are best placed on Apache channels. Talend product specific questions
should rather be placed on Talend channels.


Design Notes / Common Patterns in the examples
===============================================================================

Most examples use hierarchical maven project with a top level pom that is also the parent and several 
subprojects:

- client : Client code that can typically be called using maven exec:java
- common : Model objects or generated code that is shared between client and server
- server: Server implementation and eventually starters
- war : Packages common + server into a .war archive to be deployed on a servlet container

The structure and patterns used in the examples incorporates many best practices that are well known
for maven projects. Still some of them are described below as especially people with no maven background
will probably not know them.


Running standalone
-------------------------------------------------------------------------------

To run the examples standalone mvn exec:java is used. If there is only one Starter class then this is configured in
the pom so no extra parameters are needed. If there are more Starter classes then the class has to be specified using
mvn exec:java -Dexec.mainClass=<Full Qualified Name of the starter class>.
The starter classes typically load a Spring Context. The server starters start directly from the spring context. The client
starters retrieve the client from the context and start it.


Running in Servlet Container
-------------------------------------------------------------------------------

The server project contains only the server implementation and the spring context. The war project contains the web.xml and
all other web resources needed to create a complete .war archive. In the pom.xml the maven jetty plugin is configured so the war can
be easily deployed and started using "mvn jetty:run".

Additionally the /src/test/java contains a JettyStarter.java that can be started from eclipse as a Java Appliction for easy debugging.


Running in OSGi
-------------------------------------------------------------------------------

The common and server projects are packaged as OSGI bundles so they can be used in and outside of an OSGI container.
There is typically one spring file that is used for non OSGI deployments. For OSGI deployment Spring OSGI is used. So an 
additional spring config in META-INF/spring is used to start the bundle in an OSGI environment this context contains all 
beans that are OSGI specific and imports the non OSGI spring context.

To create the bundles the maven bundle plugin is used. This plugin by default imports all java packages that are imported in
java code and exports all packages from the bundle. As some code is only referenced from spring these packages or
bundles have to be specified in the configuration of the maven bundle plugin. 

Generally OSGi containers remember their state. So to make sure an example runs like the first time the container is best reset.
In Talend Integration Factory Container (Karaf) this can be easily done by deleting the data directory.
