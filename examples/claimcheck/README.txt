EAI patterns example ( Claim Check, Splitter, Resequencer, Delayer)
===============================================================================

Our business case for the example is a video producer that wants to send a video through a network that can not transport large messages and that
scrambles the sequence of messages.

 
1) The sender 
File => Splitter => CheckIn => Ordered Queue

The example starts with a directory where the file is dropped. The file is then splitted (in our case by new lines). In a real video case
by a maximum packet size. Then the mass data is checked into a DataStore and replaced by an Claim tag (an ID). Then the message is sent to a queue

2) Delayer
Ordered Queue => Delayer => Unordered Queue

This part is only necessary to ensure the messages get scrambled. In reality you just would use the unreliable network 

3) Claim and Resequencer
Unordered Queue => Claim => Resequencer

The messages are received from the queue. The mass data is fetched again and last the messages are brought into sequence again 


The Patterns used
===============================================================================

Claim Check
----------- 
This pattern shows how to improve message throughput and reduce load on your service bus.
The claim check pattern is one of the Enterprise Integration patterns explained at http://www.eaipatterns.com/StoreInLibrary.html.
It refers to the baggage check in and claim at airports. The passenger checks in his luggage where it is handled separately and reclaims is at the destination. 

Another nice article about the claim check pattern can be found here:
http://www.ibm.com/developerworks/websphere/library/techarticles/1006_kharlamov/1006_kharlamov.html

Splitter
---------

As splitter splits one large message into several smaller ones
See: http://camel.apache.org/splitter.html

Resequencer
-----------

If your messages come out of order the resequencer allows to bring them into sequence again
See: http://camel.apache.org/resequencer.html

Delayer
-------

A delayer stops a message and forwards it after some time. In the example we write the delayer using a bean to achieve a random delay
See: http://camel.apache.org/delayer.html


Usage
===============================================================================

Start Standalone
----------

> cd server; mvn camel:run

Start in jetty
--------

> cd war; mvn jetty:run

Start in the OSGI container
---------------------

karaf@tif> features:install tif-example-claimcheck


Process a file
--------------

Then copy a text file (e.g. the ReadMe.txt) into the in directory and watch the log

Each line of the file will be output for each stage in the route. It looks like this:
route4 INFO  claimed 3 Our business case for the example
- "claimed means that the mass data has been claimed again
- "3" is the part / line number
- "Our business case ... " is the content of the body of the message

Unordered:
   The lines starting with unordered show the state after splitting and check in of the mass data. The line numbers will be scrambled and the real content 
   is replaced by the "claim tag" (a uuid to later retrieve the data)

Claimed:
   The message content has been retrieved again but the lines are still scrambled
   
Ordered:
   The messages are now also ordered. So the original content should be readable in the log


