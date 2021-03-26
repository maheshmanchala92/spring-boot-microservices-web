package com.training.add.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.training.add.model.Item;
import com.training.add.service.ItemSearchService;

@RestController
public class AddItemListController {
	
	@Autowired
	private ItemSearchService itemSearchService;

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${message}")
	private String message;

	@Value("${server.port}")
	private String serverPort;
	
	@PostMapping("/saveItem")
	public Item saveItem(@RequestBody Item item) {
		return itemSearchService.saveItem(item);
	}
	
	@GetMapping(value = "/message")
	@HystrixCommand(fallbackMethod = "errorMessage123")
	public Object getMessage() {
		String m2 =  restTemplate.getForObject(
				"http://ITEMLIST-SEARCH-SERVICE/itemsearch/message", String.class);
		return message + " PORT = " + serverPort + " ==> " + m2;
	}
	
	public Map<String, String> errorMessage123() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "Service is temporarily unavailable please try again later!!!");
		return map;
	}

}
