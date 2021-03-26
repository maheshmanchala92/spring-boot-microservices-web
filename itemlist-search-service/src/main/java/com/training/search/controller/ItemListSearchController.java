package com.training.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.search.model.Item;
import com.training.search.service.ItemSearchService;

@RestController
@RequestMapping("itemsearch")
public class ItemListSearchController {
	
	@Autowired
	private ItemSearchService itemSearchService;
	
	@Value("${message}")
	private String message;

	@Value("${server.port}")
	private String serverPort;
	
	@GetMapping(value = "/getItems")
	public List<Item> getItems() {
		return itemSearchService.getItems();
	}
	
	@GetMapping(value = "/getItemById/{itemId}")
	public Item getItemById(@PathVariable("itemId") Long itemId) {
		return itemSearchService.getItemById(itemId);
	}
	
	@GetMapping(value = "/getItemByName/{itemName}")
	public Item getItemByName(@PathVariable("itemName") String itemName) {
		return itemSearchService.getItemByName(itemName);
	}
	
	@GetMapping(value = "/message")
	public String getMessage() {
		return message + " PORT = " + serverPort;
	}
}
