package com.redhat.camel.cxf.ngis;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
 * 
 * - From File:
 * 		(curl http://int.dca.tid.es/NGSI10/updateContext -s -S 
			--header 'Content-Type: application/json' --header 'Accept: application/json' 
			--header 'Fiware-Service: fuse' 
			-d @testCurlFromFile.json | python -mjson.tool) 
 * 
 * @author dbericat
 *
 */

@Path(value="/")
public interface OrionContextBroker {
	
	@POST
	@Path("updateContext")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateContext(String content);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
