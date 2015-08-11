package com.redhat.camel.cxf.ngis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.cxf.message.MessageContentsList;
import org.apache.camel.*;
import org.apache.camel.component.file.GenericFile;

/**
 * WS to call the Orion Context Broker: http://int.dca.tid.es/NGSI10
 * 
 * Examples:
 * - With the body: 
 * 		(curl http://int.dca.tid.es/NGSI10/updateContext -s -S 
			--header 'Content-Type: application/json' --header 'Accept: application/json' 
			--header 'Fiware-Service: fuse' 
			-d @- | python -mjson.tool) <<EOF
			{
			    "contextElements": [
			        {
			            "type": "Room",
			            "isPattern": "false",
			            "id": "Room1",
			            "attributes": [
			            {
			                "name": "temperature",
			                "type": "float",
			                "value": "23"
			            },
			            {
			                "name": "pressure",
			                "type": "integer",
			                "value": "720"
			            }
			            ]
			        }
			    ],
			    "updateAction": "APPEND"
			}
			EOF
  
 * - From File:
 * 		(curl http://int.dca.tid.es/NGSI10/updateContext -s -S 
				--header 'Content-Type: application/json' 
				--header 'Accept: application/json' 
				--header 'Fiware-Service: fuse' 
				-d @testCurlFromFile.json | python -mjson.tool) 
 * 
 * @author dbericat
 *
 */
public class FromNGISRequestToOrionContextBroker implements Processor {
	@Override
	public void process(Exchange exchange) throws Exception {
        exchange.setPattern(ExchangePattern.InOut);
        Message inMessage = exchange.getIn();
        // set the operation name
        inMessage.setHeader(CxfConstants.OPERATION_NAME, "updateContext");
        // using the proxy client API
        inMessage.setHeader(CxfConstants.CAMEL_CXF_RS_USING_HTTP_API, Boolean.FALSE);
        
        /*
         *  --header 'Content-Type: application/json' 
			--header 'Accept: application/json' 
			--header 'Fiware-Service: fuse'
         */
        inMessage.setHeader("Content-Type", "application/json");
        inMessage.setHeader("Accept", "application/json");
        inMessage.setHeader("Fiware-Service", "fuse");
        
        //creating the request. It will be the content of the body ngisRequest.json
        MessageContentsList req = new MessageContentsList();
        String content = inMessage.getBody(String.class);
        inMessage.setBody(content);
	}
}
