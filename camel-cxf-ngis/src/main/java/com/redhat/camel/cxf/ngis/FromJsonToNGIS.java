package com.redhat.camel.cxf.ngis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Mock to simulate the transformation from JCDecaux json file to NGIS json compliant.
 * 
 * It will be replaced by a proper data transformation. 
 * 
 * @author dbericat
 *
 */
public class FromJsonToNGIS implements Processor {
	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.setPattern(ExchangePattern.InOut);
		Message inMessage = exchange.getIn();
		
		//TODO: Transform the message
	}	
}
