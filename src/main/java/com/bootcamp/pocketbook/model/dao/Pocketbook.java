package com.bootcamp.pocketbook.model.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.math.BigDecimal;

@Data
@Document(value = "pocketbook")
public class Pocketbook {
	@Id
    private String id;
	
	private String typeDocument;

	private String imei;

	private String email;

	private String debitCard;

	private BigDecimal balance;

}
