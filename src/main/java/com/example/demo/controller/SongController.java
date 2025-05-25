package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ISongService;
import com.example.demo.service.to.SongTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/songs")
@CrossOrigin
public class SongController {

    @Autowired
    private ISongService songService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Boolean insertSong(@RequestBody SongTO song) {
		try {
			return this.songService.insert(song);
		} catch (Exception e) {
			return false;
		}
	}

	// GET
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SongTO> findById(@PathVariable("id") Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.songService.findById(id));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SongTO>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(this.songService.findAll());
	}

	// PUT
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SongTO> put(@RequestBody SongTO song, @PathVariable("id") Integer id) {

		return ResponseEntity.status(HttpStatus.OK).body(this.songService.put(id, song));
	}

	// DELETE
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		this.songService.delete(id);
	}
    
    
}
