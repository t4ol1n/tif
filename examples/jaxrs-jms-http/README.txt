Example for publishing CXF JAXRS services using Camel
===============================================================================

The example shows how a simple JAX-RS service called BookStore can be offered and used using 
camel transports. The example also shows some best practices how to decouple your business logic from
the Camel and CXF frameworks.  

The client project contains a standalone client that calls several service methods using the BookStore 
interface. 


Usage
===============================================================================


1) Building the Demo
-------------------------------------------------------------------------------

Using either UNIX or Windows:
> mvn clean install


2) Running the JMS Broker
-------------------------------------------------------------------------------

The sample requires a JMS broker to be running.  There are two
ways to get a JMS broker running:

2.1) From the command line
In separate command windows/shells:
> mvn -Pjms.broker

3) Starting the Service
-------------------------------------------------------------------------------

3.1) Standalone
> cd service ; mvn exec:java
     
3.2) In Jetty
> cd war ; mvn jetty:run

3.3) From within the OSGi container
karaf@tif> features:install tif-example-jaxrs-jms-http
   "list | grep TIF" should now show the bundle of the example the server bundle should be in status started


4) Running the Client
-------------------------------------------------------------------------------
 
From the command line:
> cd client ; mvn exec:java


5) Cleaning up
---------------------------------------
To remove the code generated from the WSDL file and the .class
files, run "mvn clean".

