package com.Flipkart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.Flipkart")
@EnableTransactionManagement
@PropertySource(value = "classpath:Application.properties",ignoreResourceNotFound = false)
public class AppConfig extends WebMvcConfigurerAdapter {

	@Autowired
	Environment env;
	
//	cors configuration to allow access from another origin server access
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(env.getProperty("cors.addmapping"))
                .allowedOrigins(env.getProperty("cors.origin"))
                .allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
    }
	
	
}
