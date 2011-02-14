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

  * From the command line, run:
     mvn -Pjms.broker

  That will create a new broker broker with the defaults and
  will then start it.


3) Starting the Service
-------------------------------------------------------------------------------

  * From the command line:
     cd service ; mvn exec:java

  * From within the OSGi container command line, run:
      features:install tif-example-jaxws-jms


4) Running the Client
-------------------------------------------------------------------------------

  * From the command line:
     cd client ; mvn exec:java


5) Cleaning up
-------------------------------------------------------------------------------
  * To remove the code generated from the WSDL file and the .class files, run:
     mvn clean
     