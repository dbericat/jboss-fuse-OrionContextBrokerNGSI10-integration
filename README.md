# jboss-fuse-orionContextBrokerNGSI10

JBoss Fuse project to integrate Orion Context Broker in NGSI10 notation.

SUBPROJECTS:
  * v1.0 -> /camel-cxf-ngis -> Initial version for PoC demo purposes. Please note that:

       1- It is not unmarshaling nor marshaling 'position' property to simplify the transformation. 
          You can add it to 'FromJsonToNGISProcessor'. 

       2- Logic is splitted in 3 routes generating files to add intermediate steps. 
          I think it is useful to understand what is going on. 

       3- WS calls and their parameters are hardcoded within the code.

TODO:

  * v2.0 -> Use the new data mapper tool to transform the jsons. 

  * v3.0 -> Encapsulate NGSI calls in a new Camel component. 


