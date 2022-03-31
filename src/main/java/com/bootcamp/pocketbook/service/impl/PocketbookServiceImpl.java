package com.bootcamp.pocketbook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.pocketbook.model.dao.Pocketbook;
import com.bootcamp.pocketbook.repository.PocketbookCrudRepository;
import com.bootcamp.pocketbook.service.PocketbookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PocketbookServiceImpl implements PocketbookService{
	
	@Autowired
	private PocketbookCrudRepository repository;
	
	public Flux<Pocketbook> findAll() {
        return repository.findAll();
    }

    public Mono<Pocketbook> findById(String id) {
        return repository.findById(id);
    }

    public Mono<Pocketbook> save(Pocketbook pocketbook) {
        return repository.save(pocketbook);
    }

    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }

}
