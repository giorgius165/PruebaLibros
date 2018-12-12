package com.prueba.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.prueba.model.Libro;

@Repository
public class LibroRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public void insert(Libro libro) {
		String sql = "INSERT INTO libro (id,nombre,autor)" + "VALUES ( :id, :nombre, :autor)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", libro.getId());
		params.addValue("nombre", libro.getNombre());
		params.addValue("fechaEstreno", libro.getAutor());
		namedJdbcTemplate.update(sql, params);
	}

	public void update(Libro libro) { 
		String sql = "UPDATE libro SET " + "nombre = ?, autor = ? WHERE id = ?";
		jdbcTemplate.update(sql, libro.getNombre(), libro.getAutor(), libro.getId());
	}

	public List<Libro> listAllLibros() {
		String sql = "SELECT * FROM Libro";
		List<Libro> listLibro = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Libro.class));
		return listLibro;
	}

	public void delete(String tablename, int id) { 
		String sql = "DELETE FROM " + tablename + " WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}