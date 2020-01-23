package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.services.Producer;

@RestController
public class KafkaController {

	private final Producer producer;

	@Autowired
	public KafkaController(Producer producer) {
		this.producer = producer;
	}

	@PostMapping(value = "/publish")
	public void publishMessageToKafkaTopic(@RequestParam("message") String message) {
		this.producer.sendMessage(message);
	}
	
	@GetMapping(value = "/message/{text}")
	public void sendMessageToKafkaTopic(@PathVariable("text") String text) {
		this.producer.sendMessage(text);
	}
}
