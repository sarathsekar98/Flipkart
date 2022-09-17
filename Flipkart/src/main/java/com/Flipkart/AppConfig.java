package com.Flipkart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.Flipkart")
@PropertySource(value = "Application.properties",ignoreResourceNotFound = false)
public class AppConfig extends WebMvcConfigurerAdapter {

	@Autowired
	Environment env;
	
//	cors configuration to allow access from another origin server access
	
	@Override
	public void addCorsMappings(CorsRegistry registry) 
	{
		// TODO Auto-generated method stub
		registry
		.addMapping(env.getRequiredProperty("cors.addmapping"))
		.allowedOrigins(env.getRequiredProperty("cors.origin"));
	}
	
}
