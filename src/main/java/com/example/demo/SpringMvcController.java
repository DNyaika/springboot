package com.example.demo;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Player;
import com.example.demo.domain.Team;

@Controller
public class SpringMvcController {
	
	private Team team;
	
	@PostConstruct
	public void init() {
		Set<Player> players = new HashSet<>();
		players.add(new Player("Charlie Brown", "Pitcher"));
		players.add(new Player("Snoopy", "Shortstop"));
		team = new Team("Carlifornia", "Peanuts", players);
	}
	
	
	@RequestMapping("/hi")
	public @ResponseBody Team hiThere() {
		return team;
	}

}
