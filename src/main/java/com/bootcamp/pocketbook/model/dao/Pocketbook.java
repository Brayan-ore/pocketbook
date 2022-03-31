package com.bootcamp.pocketbook.model.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(value = "pocketbook")
public class Pocketbook {
	@Id
    private String id;
	
	private String type_docuemnt;
	private String cel;
	private String imei;
	private String email;
	private String number_account;
	
}
