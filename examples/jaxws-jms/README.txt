Example for publishing CXF services using Camel JMS
===============================================================================

This Example shows how to publish and call a CXF service using SOAP/JMS. While this can also be done
using pure CXF the example shows how to do this using camel as the transport in CXF and a camel
route that does the transport. 

The Advantage over a pure CXF aproach is that you can easily do camel transformations and routings using
camel routes. Camel also offers other CXF integrations. The Camel transport for CXF was chosen here as
it offers the easiest integration for an existing CXF endpoint as you only switch the transport and can
leave the rest of the CXF configuration as is.


Usage
===============================================================================

1) Building the Demo
-------------------------------------------------------------------------------
  
Using either UNIX or Windows:

    mvn install


2) Running the JMS Broker
-------------------------------------------------------------------------------

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


3) Starting the Service
-------------------------------------------------------------------------------

  * From the command line:
     cd service ; mvn exec:java

  * From within the OSGi container
     From the OSGi command line, run:
	install mvn:com.talend.sf.examples.jaxws-jms-spec/jms-spec-common/1.0
        install mvn:com.talend.sf.examples.jaxws-jms-spec/jms-spec-server/1.0
     That should print out the bundle ID for the server bundle.  From 
     the OSGi command line, then run
        start 115
     where 115 is the bundle ID number that was printed during install.


4) Running the Client
-------------------------------------------------------------------------------

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



5) Cleaning up
-------------------------------------------------------------------------------
To remove the code generated from the WSDL file and the .class
files, run "mvn clean".

