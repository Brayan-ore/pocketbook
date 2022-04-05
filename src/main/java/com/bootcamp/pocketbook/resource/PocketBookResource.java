package com.bootcamp.pocketbook.resource;

import com.bootcamp.pocketbook.model.dao.Pocketbook;
import com.bootcamp.pocketbook.service.PocketbookService;
import com.bootcamp.pocketbook.webclient.PersonalAccountWebclient;
import com.bootcamp.pocketbook.webclient.dto.BankAccountDto;
import com.bootcamp.pocketbook.webclient.dto.BankDebitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class PocketBookResource {

    @Autowired
    private PocketbookService pocketbookService;

    @Autowired
    private PersonalAccountWebclient personalAccountWebclient;

    public Mono<Pocketbook> save(Pocketbook pocketbook) {
        return pocketbookService.findById(pocketbook.getId())
                .flatMap(x -> (x != null) ? Mono.error(new Exception("Already exists")) : Mono.just(x))
                .switchIfEmpty(saveLogic(pocketbook));
    }

    public Mono<Pocketbook> update(Pocketbook pocketbook) {
            return pocketbookService.save(pocketbook);
    }

    private Mono<Pocketbook> saveLogic(Pocketbook pocketbook) {
        if(pocketbook.getDebitCard() != null) {
            return personalAccountWebclient.findByDebitCard(pocketbook.getDebitCard())
                    .switchIfEmpty(Mono.error(new Exception("Debit card not encountered")))
                    .flatMap(x ->  pocketbookService.save(pocketbook));
        } else {
            pocketbook.setBalance(new BigDecimal(0));
            return pocketbookService.save(pocketbook);
        }
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
