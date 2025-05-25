package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.model.Artist;

public interface IArtistRepository {

    public boolean save(Artist artist);
    public Artist findById(Integer id);
    public List<Artist> findAll();
    public Artist put(Artist artist);
    public void delete(Integer id);
    
}
