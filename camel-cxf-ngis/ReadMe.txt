JBoss Fuse project to integrate and Orion Context Broker in NGSI10 notation to any "from" source
================================================================================================

To build this project use

    mvn clean install

To deploy the project in JBoss Fuse 6.2, you need to install the following features first:

    features:install camel-jackson

And then you can install this example from its shell:

    osgi:install -s mvn:com.redhat/camel-cxf-ngis/1.0.0-SNAPSHOT
