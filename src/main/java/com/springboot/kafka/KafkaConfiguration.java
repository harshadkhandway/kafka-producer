package com.springboot.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.springboot.kafka.model.UserProfile;
import com.springboot.kafka.serializer.UserProfileSerializer;

@Configuration
public class KafkaConfiguration {
	
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;
	
	@Value("${spring.kafka.security.protocol}")
	private Object securityProtocol;
	
	
	@Bean
	KafkaTemplate<String, UserProfile> kakfaTemplate() {
		return new KafkaTemplate<>(kafkaProducerFactory());
	}
	
	@Bean
	ProducerFactory<String, UserProfile> kafkaProducerFactory() {
		
		Map<String, Object> configMap = new HashMap<>();
		configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, UserProfileSerializer.class.getName());
		configMap.put(ProducerConfig.SECURITY_PROVIDERS_CONFIG, securityProtocol);
		ProducerFactory<String, UserProfile> factory = new DefaultKafkaProducerFactory<>(configMap);
		return factory;
	}
	
}
