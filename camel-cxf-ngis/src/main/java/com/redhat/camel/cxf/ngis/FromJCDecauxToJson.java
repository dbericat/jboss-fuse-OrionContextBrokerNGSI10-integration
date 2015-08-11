package com.redhat.camel.cxf.ngis;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;
import org.apache.cxf.message.MessageContentsList;

/**
 * WS to test JCDecaux: https://developer.jcdecaux.com/#/opendata/vls?page=dynamic
 * dbericat key 35a79564d35ffbf6c0ea823ffa088bbe46311dd9
 * 
 * Examples:
 * 		- Get all the stations: https://api.jcdecaux.com/vls/v1/stations?contract=Valence&apiKey=35a79564d35ffbf6c0ea823ffa088bbe46311dd9
 * 		- Get only the station 233: https://api.jcdecaux.com/vls/v1/stations/233?contract=Valence&apiKey=35a79564d35ffbf6c0ea823ffa088bbe46311dd9
 * 
 * @author dbericat
 *
 */
public class FromJCDecauxToJson implements Processor{
    @Override
    public void process(Exchange exchange) throws Exception {
            exchange.setPattern(ExchangePattern.InOut);
            Message inMessage = exchange.getIn();
            // set the operation name
            inMessage.setHeader(CxfConstants.OPERATION_NAME, "getStationFromContractById");
            // using the proxy client API
            inMessage.setHeader(CxfConstants.CAMEL_CXF_RS_USING_HTTP_API, Boolean.FALSE);
             
            //creating the request
            MessageContentsList req = new MessageContentsList();
            String contract = "Valence";
            String apiKey = "35a79564d35ffbf6c0ea823ffa088bbe46311dd9";
            req.add(contract);
            req.add(apiKey);
            inMessage.setBody(req);
 
        }
}
