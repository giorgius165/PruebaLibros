package com.prueba.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.model.Libro;
import com.prueba.service.LibroService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/v1/libro")
public class LibrosController {

	@Autowired
	private LibroService service;

	@RequestMapping(value = "/delete/{tablename}/", method = RequestMethod.GET)
	public ResponseEntity delete(@PathVariable String tablename, @RequestParam(required = false) Integer id) {
		service.delete(tablename, id);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping
	@RequestMapping(value = "/create")
	public ResponseEntity<Libro> create(@RequestBody Libro libro) {
		service.insert(libro);
		return new ResponseEntity<>(libro, HttpStatus.CREATED);
	}

	@PostMapping
	@RequestMapping(value = "/list")
	public ResponseEntity<List<Libro>> ListAllLibros() {
		return new ResponseEntity<>(service.listAllLibros(), HttpStatus.CREATED);
	}

}