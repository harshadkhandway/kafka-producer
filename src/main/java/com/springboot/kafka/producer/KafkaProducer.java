package com.springboot.kafka.producer;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import com.springboot.kafka.model.UserProfile;

@Component
public class KafkaProducer {
	
	@Value("${spring.kafka.template.default-topic}")
	private String topic;
	
	@Autowired
	private KafkaTemplate<String, UserProfile> template;
	
	
	public int postMessage(UserProfile userProfile) {
		 CompletableFuture<SendResult<String, UserProfile>> future
		 = template.send(topic, userProfile);
		 
		 future.handle((result, exception) -> {
			 System.out.println("------------ Results -----------");
			 System.out.println(result.getProducerRecord().value().toString());
			 System.out.println(exception);
			 return null;
		 });
		 
		 return 0;
	}
	
}
