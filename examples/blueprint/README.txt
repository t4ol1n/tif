Blueprint
=========
The camel-blueprint component allows you to deploy Camel routes as an OSGi bundle in the TIF container.

The Camel DS is embedded in a blueprint context.

Simple
------
The simple.xml is a blueprint definition allowing you to define a route with a timer.
Every 5 seconds, the time creates an event and use a contant body string with just "Hello World".
This string is send to a stream endpoint which displays the "Hello World" string into the TIF console.

Recipient List
--------------
The recipientlist.xml is a blueprint definition is quite the same as the simple one.
But, in addition of the stream endpoint, the message is send to a file endpoint too.

Usage
===============================================================================

Hot deployment
--------------
Start the TIF container

> cd container/bin/tif

Install the required features

> features:install camel-blueprint
> features:install camel-stream

Simply drop the src/main/resources/simple.xml or src/main/resources/recipientlist.xml in the container/deploy directory.

You should be able to see the OSGi for your Camel blueprint using

> osgi:list

Every 5 seconds, you will see the "Hello World" message in the TIF console.
