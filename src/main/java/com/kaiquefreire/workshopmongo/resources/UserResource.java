package com.kaiquefreire.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kaiquefreire.workshopmongo.domain.User;
import com.kaiquefreire.workshopmongo.dto.UserDTO;
import com.kaiquefreire.workshopmongo.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserServices service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {

		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		// .ok(), vai instanciar o response
		// o corpo da resposta vai ter essa lista
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto ) {
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri(); // pegando o endereço do novo objeto que for inserido
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
		User obj = service.fromDTO(objDto); // instanciando obj através do obj da requisição 
		obj.setId(id); // fazendo a troca do id
		obj = service.update(obj); // chamand o método update
		return ResponseEntity.noContent().build();
	}
}
