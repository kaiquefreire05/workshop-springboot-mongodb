package com.kaiquefreire.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaiquefreire.workshopmongo.domain.User;
import com.kaiquefreire.workshopmongo.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
