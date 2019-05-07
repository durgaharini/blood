package com.blooddonation.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blooddonation.model.User;
import com.blooddonation.service.BloodServiceimpl;

@Controller
public class BloodController {
	@Autowired
	private BloodServiceimpl service;
	@RequestMapping(value="/start")
	public String goHome()
	{
		return "home";
	}
	@RequestMapping(value="/register")
	public String doregister(@ModelAttribute User user,Map<String,String>map)
	{
		if(service.doregister(user) !=null)
		{
		map.put("msg1","Welcome"+user.getName());
		return 	"success";
		}
		else
		{
			map.put("msg2","please enter the details");
			return "error";
		}
	}
	
}
