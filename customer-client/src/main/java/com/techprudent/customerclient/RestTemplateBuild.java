package com.techprudent.customerclient;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateBuild {

	/*
	 * How to create a rest template? - rest template or resttemplatebuilder
	 * 
	 */
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder rtb) {

//		How to Add authorization in rest template client?

		return rtb
//				.basicAuthorization("user", "password")
				.build();

	}

}
