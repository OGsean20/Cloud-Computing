package com.rest.jersey.calculator;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.client.ClientConfig;

public class ClientCalc {

	private static final String webServiceURI = "http://localhost:8080/Calculator";

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
		WebTarget webTarget = client.target(serviceURI);
		
		System.out.println("\nUsing GET PATH parameters to invoke a RESTful service returning XML output:");
		
		System.out.println(webTarget.path("calc").path("sub").path("67").path("45").request()
				.accept(MediaType.TEXT_XML).get(String.class));
		
		System.out.println("\n");
		
		System.out.println(webTarget.path("calc").path("add").path("6").path("4").request()
				.accept(MediaType.TEXT_XML).get(String.class));
		
		System.out.println("\n");
		
		System.out.println(webTarget.path("calc").path("mul").path("4").path("2").request()
				.accept(MediaType.TEXT_XML).get(String.class));
		
		System.out.println("\n");
		
		System.out.println(webTarget.path("calc").path("div").path("10").path("2").request()
				.accept(MediaType.TEXT_XML).get(String.class));
		
		System.out.println("\n");
		
		System.out.println(webTarget.path("calc").path("sqrt").path("10").request()
				.accept(MediaType.TEXT_XML).get(String.class));
		
        System.out.println("\n");
		
		System.out.println(webTarget.path("calc").path("pow").path("10").path("2").request()
				.accept(MediaType.TEXT_XML).get(String.class));
		
        System.out.println("\n");
		
		System.out.println(webTarget.path("calc").path("fac").path("4").request()
				.accept(MediaType.TEXT_XML).get(String.class));
		
        System.out.println("\n");
		
		System.out.println(webTarget.path("calc").path("sin").path("4").request()
				.accept(MediaType.TEXT_XML).get(String.class));
		
        System.out.println("\n");
		
		System.out.println(webTarget.path("calc").path("cos").path("4").request()
				.accept(MediaType.TEXT_XML).get(String.class));
		
        System.out.println("\n");
		
		System.out.println(webTarget.path("calc").path("tan").path("4").request()
				.accept(MediaType.TEXT_XML).get(String.class));
	}

}
