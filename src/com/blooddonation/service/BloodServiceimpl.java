package com.blooddonation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blooddonation.dao.BloodDao;
import com.blooddonation.model.User;

@Service("bloodservice")
public class BloodServiceimpl implements BloodService{
	@Autowired
	private BloodDao dao;
	@Override
	public User doregister(User user)
	{
		dao.doregister(user);
		return null;
	}

}
