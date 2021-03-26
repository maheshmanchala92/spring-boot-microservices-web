package com.training.search.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.search.exception.ItemNotFoundException;
import com.training.search.model.Item;
import com.training.search.repository.ItemSearchRepository;

@Service
public class ItemSearchServiceImpl implements ItemSearchService {

	@Autowired
	private ItemSearchRepository itemSearchRepository;

	@Override
	public List<Item> getItems() {
		return itemSearchRepository.findAll();
	}

	@Override
	public Item getItemById(Long itemId) {
		Optional<Item> op = itemSearchRepository.findById(itemId);
		if (op.isPresent()) {
			return op.get();
		}
		throw new ItemNotFoundException("Item not found with id = " + itemId);
	}

	@Override
	public Item getItemByName(String itemName) {
		Optional<Item> op = itemSearchRepository.findByItemName(itemName);
		if (op.isPresent()) {
			return op.get();
		}
		throw new ItemNotFoundException("Item not found with itemName = " + itemName);
	}

}
