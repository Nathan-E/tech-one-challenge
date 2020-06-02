package com.decagonhq.version1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.sun.net.httpserver.HttpHandler;

@SpringBootApplication
public class DecagonhqTechStageOneApplication {
	
	/**
	 *  create a bean, and by default bean is 
		singleton, so that you can share this across all the project
	 * @param args
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		
		return new RestTemplate();
	}
	
	@Bean
	public WebClient.Builder getWebClientBuilder() {
		
		return WebClient.builder()
				.baseUrl("https://jsonmock.hackerrank.com/api/article_users")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DecagonhqTechStageOneApplication.class, args);
	}

}
