package com.formacionbdi.microservicios.commons.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.microservicios.commons.services.CommonService;



@RestController
public class CommonController<E,S extends CommonService<E>> {
	
	@Autowired
	protected S service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(service.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?>ver(@PathVariable Long id){
		Optional<E> o = service.findById(id);
		if (Optional.empty() == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody E entity){
		E entitydb = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entitydb);
	}
	


	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar (@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
