package com.bootcamp.pocketbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.pocketbook.model.dao.Pocketbook;
import com.bootcamp.pocketbook.service.PocketbookService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/pocketbook")
@RequiredArgsConstructor
public class PocketbookController {

    @Autowired
	private PocketbookService service;

	@GetMapping
    public Flux<Pocketbook> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Pocketbook> findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping("/upload")
    public Mono<Pocketbook> save(@RequestBody Pocketbook pocketbook) {
        return service.save(pocketbook);
    }

    @PutMapping
    public Mono<Pocketbook> put(@RequestBody Pocketbook pocketbook) {
        return service.save(pocketbook);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.deleteById(id);
    }
	
}
