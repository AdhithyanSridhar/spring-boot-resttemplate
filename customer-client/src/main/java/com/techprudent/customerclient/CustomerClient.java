package com.techprudent.customerclient;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomerClient {

	@Autowired
	private RestTemplate rt;

	@Autowired
	private ObjectMapper om;

	@PostConstruct
	private void executeRequests() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("\n\n\n");

//		How to call rest service and consume data in client?
//		- getForObject
		Customer customerObj = this.rt.getForObject("http://localhost:8080/customer/tech", Customer.class);
		System.out.println("getForObject: " + customerObj);

//		- getForEntity
		ResponseEntity<Customer> customerEntity = this.rt
				.getForEntity("http://localhost:8080/customer/responseentity/tech", Customer.class);

		System.out.println(customerEntity.getStatusCodeValue());
		System.out.println(customerEntity.getStatusCode());
		System.out.println(customerEntity.getHeaders());
		System.out.println(customerEntity.getBody());

//		How to get response as string?
//				- get response as string
		String customerStr = this.rt.getForObject("http://localhost:8080/customer/tech", String.class);
		System.out.println("customerStr: " + customerStr);
		
//		How to convert string and map it to an object?
//				- objectMapper convert to pojo from string json
		Customer customer = om.readValue(customerStr, Customer.class);
		System.out.println("customerObj:  " + customer);

//		How to do post request and create a resource?
//				- postForObject to create a new resource
		HttpEntity<Customer> entity = new HttpEntity<Customer>(new Customer("user", "2423", "23"));
		Customer customerCreated = this.rt.postForObject("http://localhost:8080/customer/create", entity,
				Customer.class);
		System.out.println("customerCreated: " + customerCreated);

//		What is .exchange in resttemplate?
//				- exchange - always responseEntity as return type
		HttpEntity<Customer> entity2 = new HttpEntity<>(null);
		ResponseEntity<Customer> exchange = rt.exchange("http://localhost:8080/customer/user", HttpMethod.GET, entity2,
				Customer.class);
		System.out.println(exchange.getBody());

//		Delete a resource
//		rt.delete("http://deleteurl/");

		Customer customerObject = this.rt.getForObject("http://localhost:8080/customer/tech", Customer.class);
		System.out.println("getForObject: " + customerObject);

		System.out.println("\n\n\n");

	}

}
