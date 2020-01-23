package com.company.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

	private static final String TOPIC = "users";
	
	private final Logger logger = LoggerFactory.getLogger(Consumer.class);
	@KafkaListener(topics = TOPIC, groupId = "group_id")
	public void consume(String message){
		logger.info(String.format("$$ -> Consumed Message -> %s",message));
	}
}
