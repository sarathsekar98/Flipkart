package com.Flipkart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Flipkart.Module.Signup;
import com.Flipkart.Repository.HomeRepository;

@Service
public class Homeservice {
	
	@Autowired
	HomeRepository homeRepository;

	@Transactional
	public Signup signup(Signup sign)throws Exception{
		// TODO Auto-generated method stub
		return homeRepository.signup(sign);
	}

	@Transactional
	public List<Signup> getuser() {
		// TODO Auto-generated method stub
		return homeRepository.getuser();
	}

	

}
