package com.bootcamp.pocketbook.service;

import com.bootcamp.pocketbook.model.dao.Pocketbook;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PocketbookService {
	public Flux<Pocketbook> findAll();
    public Mono<Pocketbook> findById(String id);
    public Mono<Pocketbook> save(Pocketbook pocketbook);
    public Mono<Void> deleteById(String id);
}
