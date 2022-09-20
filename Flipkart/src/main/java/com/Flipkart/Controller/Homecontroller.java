package com.Flipkart.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Flipkart.Module.Signup;
import com.Flipkart.Service.Homeservice;


@RestController
@CrossOrigin
public class Homecontroller {
	
	@Autowired
	Homeservice homeservice;
	
	@RequestMapping("/")
	public String index()
	{
		return "welcome to fullstack development";
	}
	
	@PostMapping(value = "/signup",consumes = {MediaType.APPLICATION_JSON_VALUE} ,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<Signup> signup(@RequestBody Signup sign)throws Exception
	{
	    Signup result = homeservice.signup(sign);
		return new ResponseEntity<Signup>(result,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/getuser",produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Signup> getuser()
	{
		List<Signup> s = homeservice.getuser();
		return s;
	}
	
	

}
