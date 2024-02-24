package com.springboot.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.kafka.model.UserProfile;
import com.springboot.kafka.producer.KafkaProducer;

@Service
public class ProducerService {
	
	@Autowired
	private KafkaProducer producer;

	public void createUserProfile(UserProfile userProfile) {
		int result = producer.postMessage(userProfile);
		System.out.println("Result ------- " +result);
	}

}
