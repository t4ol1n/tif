Welcome to Talend Integration Factory Community Edition!
========================================================

Talend Integration Factory Community Edition (CE) is a fully supported,
stable, production ready distribution based on the industry leading open
source integration framework Apache Camel. Apache Camel uses well known 
Enterprise Integration Patterns to make message based system 
integration simpler yet powerful and scalable. 

The Apache Camel uses a lightweight, component based architecture 
which allows great flexibility in deployment scenarios: as stand-alone
JVM applications or embedded in a servlet container such as Tomcat,
or within a JEE server, or in an OSGi container such as Equinox.  

Apache Camel and Talend Integration Factory come out of the box with 
an impressive set of available components for all commonly used protocols 
like http, https, ftp, xmpp, rss and many more. A large number of data
formats like EDI, JSON, CSV, HL7 and languages like JS, Python, 
Scala, are supported out of the box. Its extensible architecture
allows developers to easily add support for proprietary protocols
and data formats.

The Talend Integration Factory distribution supplements Apache Camel 
with support for OSGi containers, support for integrating Talend jobs on 
Camel routes and a number of advanced examples. The OSGi container uses 
Apache Karaf. It's a lightweight container providing advanced features such
as provisioning, hot deployment, logger system, dynmamic configuration,
complete shell environment, etc.  It's a professional and production ready 
kernel for the Talend Integration Factory.


Contents
========
Apache Camel
OSGi Container
Getting Started
Examples


Apache Camel
============

This package contains a complete version of Apache Camel, the industry 
leading open source integration framework.  It also includes value
added components such as an OSGi container and several new examples.
For more information about Apache Camel see http://camel.apache.org/ .  


OSGi container 
============== 

The container subdirectory contains a preconfigured OSGi container that 
contains all the required OSGi bundles for the CXF 3rd party dependencies.
It also includes Apache Karaf to provide easy administration and 
configuration.  For more information about OSGi and Apache 
Karaf see http://karaf.apache.org/ .

OSGi provides a mature, open standards based, highly modular framework for 
managing component dependencies, service invocation, and lifecycles.  It is 
the basis for Eclipse and provides a lightweight alternative to more 
monolithic JEE containers while still retaining the powerful management 
features necessary for the enterprise.



Getting Started 
===============

For information on running the Talend Integration Factory OSGi container, 
check the README file in the container folder just below this directory.

If you need more help try talking to us on our forums: http://talendforge.org/forum

You can find more information about Apache Camel at http://camel.apache.org/

Please submit CAMEL bug reports with JIRA at https://issues.apache.org/jira/browse/CAMEL

Please submit TIF bug reports with JIRA at https://jira.sopera.de/browse/IF

Examples are documented individually and include instructions for building
and running each example with just a few command lines.  See below for obtaining 
the examples.


Examples 
======== 

Talend Integration Factory CE provides several new examples in a separate download
available at http://www.talend.com/resources/documentation.php#IF .  The 
example applications and tutorials demonstrate functionality and advanced 
features of Talend Integration Factory CE.  The examples demonstrate how to use 
different functionality including:
*       Advanced WebServices with Camel
*       Security configuration within OSGi
*       Use of blueprint to define routes
and much more.


