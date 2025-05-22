package com.example.demo.repository;

import com.example.demo.repository.model.Song;

public interface ISongRepository {

    public boolean save(Song song);
    public Song findById(Integer id);
    public Song put(Song song);
    public void delete(Integer id);
    
}
