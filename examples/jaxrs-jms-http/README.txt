Example for publishing CXF JAXRS services using Camel
==================================================================

The example shows how a simple JAX-RS service called BookStore can be offered and used using 
camel transports. The example also shows some best practices how to decouple your business logic from
the Camel and CXF frameworks.  

The client project contains a standalone client that calls several service methods using the BookStore 
interface. 


Building the Demo
---------------------------------------
  
Using either UNIX or Windows:

    mvn clean install


Running the JMS Broker
---------------------------------------
The sample requires a JMS broker to be running.  There are two
ways to get a JMS broker running:

 * From the command line
     In separate command windows/shells:
     mvn -Pjms.broker

 * From within the Talend Service Factory OSGi container:
     From the OSGi command line, run:
         features:install tif-messaging (needs to be done only once)
         activemq:create-broker 
     That will create a new broker broker with the defaults and 
     will then start it.


Starting the Service
---------------------------------------
  * Standalone
     cd service ; mvn exec:java
     
  * In Jetty
     cd war ; mvn jetty:run

  * From within the OSGi container
     From the OSGi command line, run:
	install mvn:com.talend.sf.examples.jaxws-jms-spec/jms-spec-common/1.0
        install mvn:com.talend.sf.examples.jaxws-jms-spec/jms-spec-server/1.0
     That should print out the bundle ID for the server bundle.  From 
     the OSGi command line, then run
        start 115
     where 115 is the bundle ID number that was printed during install.


Running the Client
---------------------------------------
  * From the command line:
     cd client ; mvn exec:java
  * From within the OSGi container
     From the OSGi command line, run:
	install mvn:com.talend.sf.examples.jaxws-jms-spec/jms-spec-common/1.0
        install mvn:com.talend.sf.examples.jaxws-jms-spec/jms-spec-client/1.0
     That should print out the bundle ID for the client bundle.  From 
     the OSGi command line, then run
        start 115
     where 115 is the bundle ID number that was printed during install.



Cleaning up
---------------------------------------
To remove the code generated from the WSDL file and the .class
files, run "mvn clean".

