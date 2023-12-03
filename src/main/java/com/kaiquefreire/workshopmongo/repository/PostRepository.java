package com.kaiquefreire.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kaiquefreire.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{ // criando repositório MongoDB do objeto Post
	
	
}
