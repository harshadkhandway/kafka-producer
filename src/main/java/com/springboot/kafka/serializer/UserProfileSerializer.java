package com.springboot.kafka.serializer;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.kafka.model.UserProfile;

public class UserProfileSerializer implements Serializer<UserProfile> {

	@Override
	public byte[] serialize(String topic, UserProfile data) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsBytes(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
