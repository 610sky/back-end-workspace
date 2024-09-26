package com.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpa.domain.Movie;
import com.jpa.service.MovieService;

@Controller
@RequestMapping("/api/*")
public class MovieController {
	@Autowired
	private MovieService service;
	
	// 추가
	@PostMapping("/movie")
	public ResponseEntity add(@RequestBody Movie vo) {
		service.change(vo);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	//전체 조회
	@GetMapping("/movie")
	public ResponseEntity viewAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.viewAll());
	}
	
	//
	@GetMapping("/movie/{id}")
	public ResponseEntity view(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.view(id));
	}
}
