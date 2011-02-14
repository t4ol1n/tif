Talend Integration Factory Container - powered by Karaf
===============================================================================

The Talend Integration Factory Container (aka TIF Container) is a lightweight OSGi container powered by Apache Karaf.
It packs current versions of Equinox, Camel and CXF. The Container already container everything needed to run Camel
integrations and routes and CXF services.
Still it is very compatible to the pure Karaf distribution.

Starting TIF Container
======================
Go into the container bin directory:

Unix:
    cd container/bin
Windows:
    cd container\bin

Use the tif script to launch the container:

Unix:
    ./tif
Windows:
    tif.bat

tif startup script will launch the container and put into the TIF Container shell environment (the TIF console).

You can also start TIF Container in other modes:

* you can start TIF Container without the console:
Unix:
    ./tif server
Windows:
    tif.bat server

* you can start TIF Container in background:
Unix:
    ./start
Windows:
    start.bat

* you can connect to running TIF Container using the client:
Unix:
    ./client
Windows:
    client.bat

How to set up a pure Karaf to also run the examples
====================================================

1) Load the Karaf Version 2.1.3
2) Replace the etc/jre.properties with the one from the TIF container
3) Start karaf and type the following:

karaf@tif> features:addUrl mvn:org.apache.karaf/apache-karaf/${karaf.version}/xml/features
karaf@tif> features:addUrl file:${basedir}/target/classes/activemq-features.xml
karaf@tif> features:addUrl mvn:org.apache.camel.karaf/apache-camel/${camel.version}/xml/features
karaf@tif> features:addUrl mvn:com.talend.if/talend-if/2.6.0.0-SNAPSHOT/xml/features

Now you are ready to use the examples like described in each example Readme. 

The main difference is that every jar that is needed will be loaded online on demand. So make sure to use the 
Talend Integration Factory container to avoid this.


Design Notes / Common Patterns in the examples
===============================================================================

