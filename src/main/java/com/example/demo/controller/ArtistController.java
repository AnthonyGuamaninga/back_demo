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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IArtistService;
import com.example.demo.service.to.ArtistTO;

@RestController
@RequestMapping("/artists")
@CrossOrigin
public class ArtistController {

    @Autowired
    private IArtistService artistService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Boolean insertArtist(@RequestBody ArtistTO artist) {
		try {
			return this.artistService.insert(artist);
		} catch (Exception e) {
			return false;
		}
	}

	// GET
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArtistTO> findById(@PathVariable("id") Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.artistService.findById(id));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ArtistTO>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(this.artistService.findAll());
	}

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArtistTO> put(@RequestBody ArtistTO artist, @PathVariable("id") Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.artistService.put(id, artist));
	}

	// DELETE
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable("id") Integer id) {
		this.artistService.delete(id);
	}
    
}
