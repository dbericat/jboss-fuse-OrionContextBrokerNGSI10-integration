package com.redhat.camel.ngis;

import java.util.ArrayList;

import ngisrequest.Attribute;
import ngisrequest.ContextElement;
import ngisrequest.NgisRequest;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import valencerealtimestation233.ValenceRealTimeStation233;

public class FromJsonToNGISProcessor implements Processor {

	@Override
	public void process(Exchange entrada) throws Exception {
		// TODO Auto-generated method stub
		ValenceRealTimeStation233 origen=(ValenceRealTimeStation233)entrada.getIn().getBody();
		NgisRequest destino = new NgisRequest();
		destino.setUpdateAction("APPEND");
		ContextElement contextElement = new ContextElement();
		

		ArrayList<Attribute> listaAtributos = new ArrayList<Attribute>();
		ArrayList<ContextElement> listaContextElements = new ArrayList<ContextElement>();
		// creamos los atributos para el contextelemnet:
		Attribute atributo1 = new Attribute();
		atributo1.setName("number");
		atributo1.setType("integer");
		atributo1.setValue(String.valueOf(origen.getNumber()));

		Attribute atributo2 = new Attribute();
		atributo2.setName("name");
		atributo2.setType("string");
		atributo2.setValue(origen.getName());

		Attribute atributo3 = new Attribute();
		atributo3.setName("address");
		atributo3.setType("string");
		atributo3.setValue(origen.getAddress());

		Attribute atributo4 = new Attribute();
		atributo4.setName("banking");
		atributo4.setType("boolean");
		atributo4.setValue(String.valueOf(origen.isBanking()));

		Attribute atributo5 = new Attribute();
		atributo5.setName("bonus");
		atributo5.setType("boolean");
		atributo5.setValue(String.valueOf(origen.isBonus()));

		Attribute atributo6 = new Attribute();
		atributo6.setName("status");
		atributo6.setType("string");
		atributo6.setValue(origen.getStatus());

		Attribute atributo7 = new Attribute();
		atributo7.setName("contract_name");
		atributo7.setType("string");
		atributo7.setValue(origen.getContract_name());

		Attribute atributo8 = new Attribute();
		atributo8.setName("bike_stands");
		atributo8.setType("integer");
		atributo8.setValue(String.valueOf(origen.getBike_stands()));

		Attribute atributo9 = new Attribute();
		atributo9.setName("available_bike_stands");
		atributo9.setType("integer");
		atributo9.setValue(String.valueOf(origen.getAvailable_bike_stands()));

		Attribute atributo10 = new Attribute();
		atributo10.setName("available_bikes");
		atributo10.setType("integer");
		atributo10.setValue(String.valueOf(origen.getAvailable_bikes()));

		Attribute atributo11 = new Attribute();
		atributo11.setName("last_update");
		atributo11.setType("string");
		atributo11.setValue(String.valueOf(origen.getLast_update()));

		listaAtributos.add(atributo1);
		listaAtributos.add(atributo2);
		listaAtributos.add(atributo3);
		listaAtributos.add(atributo4);
		listaAtributos.add(atributo5);
		listaAtributos.add(atributo6);
		listaAtributos.add(atributo7);
		listaAtributos.add(atributo8);
		listaAtributos.add(atributo9);
		listaAtributos.add(atributo10);
		listaAtributos.add(atributo11);
		contextElement.setAttributes(listaAtributos);
		contextElement.setId(origen.getName());
		contextElement.setType("Station");
		contextElement.setIsPattern("false");
		listaContextElements.add(contextElement);
		destino.setContextElements(listaContextElements);
		entrada.getIn().setBody(destino);
		
		

	}

}
