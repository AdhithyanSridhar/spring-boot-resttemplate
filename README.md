====================================

Contact and feedback:

- https://www.youtube.com/channel/UCVyvT1t3p-ciOeInzaSbIcQ

- https://github.com/TechPrudent/

- techprudent91@gmail.com

- https://trello.com/b/8QKy3byG/techprudent

- https://techprudent91.blogspot.com/

- https://www.facebook.com/techprudents/

- https://twitter.com/techprudent

- https://www.linkedin.com/in/tech-prudent-37831216b/

- https://plus.google.com/u/0/114035390968854033062

====================================

# spring-boot-resttemplate
spring boot rest template as rest service client

spring boot rest template as rest service client
=================================================

source code is here, 
	===	customer service is already written

Please watch here on how to write rest service using spring boot,
https://www.youtube.com/watch?v=YqihJ0aImgQ

	=== Client that talks to service

How to create a rest template?
- rest template
- resttemplatebuilder

How to call rest service and consume data in client?
- getForObject
- getForEntity

How to get response as string?
- get response as string

How to convert string and map it to an object?
- objectMapper convert to pojo from string json

How to do post request and create a resource?
- postForObject to create a new resource

What is .exchange in resttemplate?
- exchange - always responseEntity as return type

Update a resource
- put 

Delete a resource

How to secure a rest service?

How to Add authorization in rest template client?


GET: 	http://localhost:8080/customer/tech
		http://localhost:8080/customer/prudent
		
POST: http://localhost:8080/customer/create
		
Customer client: output for all cases: 
======================================

getForObject: Customer [name=tech, contact=123, age=26]

200

200

{Content-Type=[application/json;charset=UTF-8], Transfer-Encoding=[chunked], Date=[Mon, 27 Aug 2018 13:03:59 GMT]}

Customer [name=tech, contact=123, age=26]

customerStr: {"name":"tech","contact":"123","age":"26"}

customerObj:  Customer [name=tech, contact=123, age=26]

customerCreated: Customer [name=user, contact=2423, age=23]

Customer [name=user, contact=2423, age=23]

getForObject: Customer [name=tech, contact=123, age=26]
