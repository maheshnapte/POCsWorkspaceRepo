package com.in28minutes.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;

// uncomment following run 
//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("jpa run started ...");
		logger.info("User id 10001 -> {}", repository.findById(10001));
		
		logger.info("Inserting -> {}", 
				repository.insert(new Person("Tara12222", "Berlin", new Date())));
		
		logger.info("Inserting -> {}", 
				repository.insert(new Person("Tara01", "Berlin01", new Date())));
		
		logger.info("Inserting -> {}", 
				repository.insert(new Person("Tara02", "Berlin02", new Date())));
		
		logger.info("Inserting -> {}", 
				repository.insert(new Person("Tara03", "Berlin03", new Date())));
		
		logger.info("Update 10003 -> {}", 
				repository.update(new Person(10003, "Pieter", "Utrecht", new Date())));
		
		repository.deleteById(10002);

		logger.info("All users -> {}", repository.findAll());
	}
}
