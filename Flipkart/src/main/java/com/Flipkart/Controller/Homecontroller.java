package com.Flipkart.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Homecontroller {
	
	@RequestMapping("/")
	public String index()
	{
		return "welcome to fullstack development";
	}
	

}
