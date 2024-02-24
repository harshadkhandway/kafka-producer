 package com.springboot.kafka.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kafka.model.UserProfile;
import com.springboot.kafka.service.ProducerService;

@RestController
public class ProducerController {
	
	private ProducerService producerService;
	
	public ProducerController(ProducerService producerService) {
		this.producerService = producerService;
	}

	@PostMapping(path = "/profile/create")
	public ResponseEntity<String> createUserProfile(@RequestBody(required = true) @Validated UserProfile userProfile) {
		producerService.createUserProfile(userProfile);
		ResponseEntity<String> entity = new ResponseEntity<>(HttpStatus.OK);
		return entity;
		
	}

}
