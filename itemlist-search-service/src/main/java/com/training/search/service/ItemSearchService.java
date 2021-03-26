package com.training.search.service;

import java.util.List;

import com.training.search.model.Item;

public interface ItemSearchService {
	
	List<Item> getItems();

	Item getItemById(Long itemId);

	Item getItemByName(String itemName);

}
