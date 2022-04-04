package com.bootcamp.pocketbook.resource;

import com.bootcamp.pocketbook.model.dao.Pocketbook;
import com.bootcamp.pocketbook.service.PocketbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PocketBookResource {

    @Autowired
    private PocketbookService pocketbookService;

    public Mono<Pocketbook> save(Pocketbook pocketbook) {

        return pocketbookService.findById(pocketbook.getId()).switchIfEmpty(pocketbookService.save(pocketbook))
                .flatMap(x -> Mono.error(new Exception("Already exists")));
    }

    public Flux<Pocketbook> findAll() {
        return pocketbookService.findAll();
    }

    public Mono<Pocketbook> findById(String id) {
        return pocketbookService.findById(id).switchIfEmpty(Mono.error(new Exception("PocketBook not exists")));
    }
    public Mono<Void> deleteById(String id) {
        return pocketbookService.findById(id).switchIfEmpty(Mono.error(new Exception("PocketBook not exists")))
                .flatMap(x -> pocketbookService.deleteById(x.getId()));
    }

}
