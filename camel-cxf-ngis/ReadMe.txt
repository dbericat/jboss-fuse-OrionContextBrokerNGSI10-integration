JBoss Fuse project to integrate Orion Context Broker in NGSI10 notation
=======================================================================

v1.0 -> /camel-cxf-ngis -> Initial version for PoC demo purposes. 

Please note that:

   1- It is not unmarshaling nor marshaling 'position' property to simplify the 
      transformation. You can add it to 'FromJsonToNGISProcessor'. 

   2- Logic is splitted in 3 routes generating files to add intermediate steps. 
      I think it is useful to understand what is going on. 

   3- WS calls and their parameters are hardcoded within the code.

To build this project use

    mvn clean install

To deploy the project in JBoss Fuse 6.2, you need to install the following features first:

    features:install camel-jackson

And then you can install this example from its shell:

    osgi:install -s mvn:com.redhat/camel-cxf-ngis/1.0.0-SNAPSHOT

EXPECTED BEHAVIOUR & HOW TO TEST
--------------------------------
1- As soon as the project is deployed, first camel route 'fromJCDecauxToFile' gets the response coming from the JCDecaux WS and store it in 'work/station/jcdecauxFile'

2- Open the file 'station.json' and delete the property 'position'. This is due to note 1 above. 

3- Save the file to the folder 'work/station/jcdecauxFileWithoutPosition'. This will execute the camel route 'fromJsonToNGIS'

4- Camel route 'fromJsonToNGIS' will do the transformation to NGSI10 and save the request at 'work/station/ngisRequest'

5- Camel route 'fromNGISrequestToOrionContextBroker' gets 'ngisRequest' automatically and connects to the Orion Context Broker through Apache CXF, saving the response at 'work/station/ngisResponse'
