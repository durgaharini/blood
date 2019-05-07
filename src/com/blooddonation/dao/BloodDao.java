package com.blooddonation.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blooddonation.model.User;

@Repository("blood dao")
public class BloodDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public User doregister(User user)
	{
	Session session=sessionFactory.getCurrentSession();
	try
	{
		session.save(user);
		User user1=(User)session.get(User.class,user.getEmail());
		if(user1==null || !user1.getPassword().equals(user.getPassword()))
		{
			return null;
		}
		return user1;
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	}

}
