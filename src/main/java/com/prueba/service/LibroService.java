package com.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.prueba.model.Libro;
import com.prueba.repository.LibroRepository;

public class LibroService {
	@Autowired
	private LibroRepository repository;

	public List<Libro> listAllLibros() {
		return repository.listAllLibros();
	}

	public void insert(Libro t) {
		repository.insert(t);
	}

	public void delete(String tablename, int id) {
		repository.delete(tablename, id);
	}

	public void update(Libro t) {
		repository.update(t);
	}
}
