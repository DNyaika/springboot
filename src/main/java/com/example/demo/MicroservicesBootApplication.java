package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.example.demo.dao.TeamDao;
import com.example.demo.domain.Player;
import com.example.demo.domain.Team;

@SpringBootApplication
public class MicroservicesBootApplication extends SpringBootServletInitializer {

	/**
	 * Used when running as a JAR
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroservicesBootApplication.class, args);
	}

	/**
	 * Used when running as a WAR
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MicroservicesBootApplication.class);
	}
	
	@PostConstruct
	public void init() {
		Set<Player> players = new HashSet<>();
		players.add(new Player("Charlie Brown", "Pitcher"));
		players.add(new Player("Snoopy", "Shortstop"));
		Team team = new Team("Carlifornia", "Peanuts", players);
		teamDao.save(team);	
	}
	
	@Autowired
	TeamDao teamDao;
	

}
