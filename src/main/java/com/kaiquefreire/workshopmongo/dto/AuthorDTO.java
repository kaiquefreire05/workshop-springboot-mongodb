package com.kaiquefreire.workshopmongo.dto;

import java.io.Serializable;

import com.kaiquefreire.workshopmongo.domain.User;

public class AuthorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	// construtores
	public AuthorDTO() {}
	
	public AuthorDTO(User obj) {
		super();
		id = obj.getId();
		name = obj.getName();
	}

	// getter e setters
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
