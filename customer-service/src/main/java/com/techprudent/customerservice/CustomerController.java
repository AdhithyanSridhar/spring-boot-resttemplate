package com.techprudent.customerservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	static List<Customer> customers;

	static {
		customers = new ArrayList<>();
		customers.add(new Customer("tech", "123", "26"));
		customers.add(new Customer("prudent", "456", "27"));
	}

	@GetMapping("/{customerName}")
	Customer getCustomer(@PathVariable String customerName) {
		return customers.stream().filter(customer -> customer.getName().equals(customerName)).findFirst().get();
	}

	@GetMapping("/responseentity/{customerName}")
	ResponseEntity<Customer> getCustomerResponseEntity(@PathVariable String customerName) {
		return new ResponseEntity<>(
				customers.stream().filter(customer -> customer.getName().equals(customerName)).findFirst().get(),
				HttpStatus.OK);
	}

	@PostMapping("/create")
	Customer createCustomer(@RequestBody Customer customerCreate) {
		return addCustomer(customerCreate);
	}

	private static synchronized Customer addCustomer(Customer customerCreate) {
		customers.add(customerCreate);
		return customers.stream().filter(customer -> customer.getName().equals(customerCreate.getName())).findFirst()
				.get();
	}
}
