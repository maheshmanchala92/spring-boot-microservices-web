package com.training.add.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.add.exception.DuplicateItemFoundException;
import com.training.add.model.Item;
import com.training.add.repository.ItemSearchRepository;

@Service
public class ItemSearchServiceImpl implements ItemSearchService {

	@Autowired
	private ItemSearchRepository itemSearchRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Item saveItem(Item item) {
		Item i = getItemByName(item);
		if (i == null) {
			return itemSearchRepository.save(item);
		}
		throw new DuplicateItemFoundException("Item Name is alredy exist!");
	}

	public Item getItemByName(Item item) {
		try {
			return restTemplate.getForObject(
					"http://ITEMLIST-SEARCH-SERVICE/itemsearch/getItemByName/" + item.getItemName(), Item.class);
		} catch (Exception e) {
			return null;
		}
	}
}
