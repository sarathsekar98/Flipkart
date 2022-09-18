package com.Flipkart.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Flipkart.Module.Signup;
import com.google.protobuf.Empty;

@Repository
public class HomeRepository {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Session setSession()
	{
		return sessionFactory.openSession();
	}
    
	@Transactional
	public Signup signup(Signup sign)throws Exception{
		Session session1 = sessionFactory.openSession();
	    int result = (Integer) session1.save(sign);
	    if(result == 0)
	    {
	    	throw new UsernameNotFoundException("user not add successfully");
	    }
	    sign.setMessage("user successfully added...");
	    return sign;
	}

}
