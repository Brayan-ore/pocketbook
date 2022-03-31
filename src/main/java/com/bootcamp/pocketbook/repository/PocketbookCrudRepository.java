package com.bootcamp.pocketbook.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.bootcamp.pocketbook.model.dao.Pocketbook;


public interface PocketbookCrudRepository extends ReactiveCrudRepository<Pocketbook, String>{

}
