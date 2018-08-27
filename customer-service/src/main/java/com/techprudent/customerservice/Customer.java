package com.techprudent.customerservice;

public class Customer {

	private String name;
	private String contact;
	private String age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Customer(String name, String contact, String age) {
		super();
		this.name = name;
		this.contact = contact;
		this.age = age;
	}
	public Customer() {
		super();
	}
	
	
}
