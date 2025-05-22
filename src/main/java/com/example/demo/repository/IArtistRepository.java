package com.example.demo.repository;

import com.example.demo.repository.model.Artist;

public interface IArtistRepository {

    public boolean save(Artist artist);
    public Artist findById(Integer id);
    public Artist put(Artist artist);
    public void delete(Integer id);
    
}
