Talend Integration Factory Container - powered by Karaf
===============================================================================

The Talend Integration Factory Container is a convenient distribution of Karaf that packs together current versions of
Equinox, Camel and CXF. The container already contains everything needed to run CXF services and Camel integrations.
Still it is very compatible to the pure Karaf distribution.


How to set up a pure Karaf to also run the examples
===============================================================================

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

