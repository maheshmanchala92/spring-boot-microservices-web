package com.training.search.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.search.model.Item;

@Repository
@Transactional
public interface ItemSearchRepository extends JpaRepository<Item, Long> {

	Optional<Item> findByItemName(String itemName);
}
