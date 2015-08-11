package com.redhat.camel.cxf.ngis;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * WS to test JCDecaux with station 233: https://developer.jcdecaux.com/#/opendata/vls?page=dynamic
 * dbericat key 35a79564d35ffbf6c0ea823ffa088bbe46311dd9
 * 
 * Examples:
 * 		- Get all the stations: https://api.jcdecaux.com/vls/v1/stations?contract=Valence&apiKey=35a79564d35ffbf6c0ea823ffa088bbe46311dd9
 * 		- Get only the station 233: https://api.jcdecaux.com/vls/v1/stations/233?contract=Valence&apiKey=35a79564d35ffbf6c0ea823ffa088bbe46311dd9
 * 
 * @author dbericat
 *
 */

@Path(value="/")
public interface JCDecaux {
	
	@GET
	@Path("233")
	@Produces({MediaType.APPLICATION_JSON})
	public String getStationFromContractById(@QueryParam("contract") String contract, @QueryParam("apiKey") String apiKey);
	
}
