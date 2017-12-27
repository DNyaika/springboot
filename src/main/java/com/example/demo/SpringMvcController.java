package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TeamDao;
import com.example.demo.domain.Team;

@RestController
public class SpringMvcController {
	@Autowired
	private TeamDao teamDao;
	
	@RequestMapping("/teams/{name}")
	public Team hiThere(@PathVariable String name) {
		Team team =teamDao.findByName(name);
		return team;
				
	}

}
