package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.domain.Movie;
import com.jpa.repo.MovieDAO;

@Service
public class MovieService {
	@Autowired
	private MovieDAO dao;
	
	public void change(Movie vo) {
		dao.save(vo);
	}
	
	public List<Movie> viewAll() {
		return dao.findAll();
	}
	
	public Movie view(int id) {
		return dao.findById(id).get();
	}
}
