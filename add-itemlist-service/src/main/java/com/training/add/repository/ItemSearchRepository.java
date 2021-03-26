package com.training.add.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.add.model.Item;

@Repository
public interface ItemSearchRepository extends JpaRepository<Item, Long>  {

}
