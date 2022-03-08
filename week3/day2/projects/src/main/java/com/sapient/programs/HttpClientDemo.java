package com.sapient.programs;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpClientDemo {

	String address;
	HttpClient client;
	
	public HttpClientDemo() {
		address  = "https://vinbasket.herokuapp.com";
		client = HttpClient.newHttpClient();
	}
	
	public void getProductDetails(int id) throws Exception {
		// build a request object
		HttpRequest request = HttpRequest.newBuilder()
			.uri(new URI(address + "/products/" + id))
			.GET()
			.header("Accept", "application/json")
			.build();
			
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
//		Set<Entry<String, List<String>>> headers = response.headers().map().entrySet();
//		for(Entry<String, List<String>> header: headers) {
//			System.out.println(header.getKey() + " --> " + header.getValue());
//		}
//		
//		System.out.println();
		
		System.out.println(response.body());
	}
	
	public void saveProductImage(int id) throws Exception {
		// TBD later
	}
	
	
	
	public void login() throws Exception  {
		// login is generally a POST request, carrying username/password in the form of request body
		String requestBody = "{\"email\": \"vinod@vinod.co\", \"password\": \"topsecret\"}";
		
		HttpRequest request = HttpRequest.newBuilder()
			.uri(new URI(address + "/login"))
			.POST(HttpRequest.BodyPublishers.ofString(requestBody))
			.header("Content-Type", "application/json") // what are you sending?
			.header("Accept", "application/json") // what are you expecting
			.build();
		
		HttpResponse<String> resp = client.send(request, BodyHandlers.ofString());
		
		System.out.println(resp.body());
	}
	
	public void printOrderDetails(int orderId) throws Exception{
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwibmFtZSI6IlZpbm9kIEt1bWFyIiwiaWF0IjoxNjQzNzA3ODE2fQ.J1dAoQIbCWi3qmKNl4x4MZ64qOFRq-bpmh5YwX2x79Q";
		String ordersUrl = address + "/orders/" + orderId;
		
		HttpRequest request = HttpRequest
				.newBuilder()
				.uri(new URI(ordersUrl))
				.GET()
				.header("Accept", "application/json")
				.header("Authorization", "Bearer " + token)
				.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		System.out.println(response.body());
	}
	
	
	public static void main(String[] args) throws Exception {

		HttpClientDemo demo = new HttpClientDemo();
		
		// demo.getProductDetails(44);
		// demo.login();
		demo.printOrderDetails(4);
		
	}

}
