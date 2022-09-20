package com.Flipkart.Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.Flipkart.Module.Signup;

@Repository
public class HomeRepository {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public Signup signup(Signup sign)throws Exception
	{
		int result;
	    Session session = sessionFactory.getCurrentSession();
	   try {
		session.save(sign);
	   } catch (Exception e) {
		// TODO: handle exception
	   }  
	    sign.setMessage("user successfully added...");
	    return sign;
	}

	public List<Signup> getuser() {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		 List<Signup> s = session.createQuery("from Signup").list();
		return s;
	}
	
	
	
}
