package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.model.Song;

public interface ISongRepository {

    public boolean save(Song song);
    public Song findById(Integer id);
    public List<Song> findAll();
    public Song put(Song song);
    public void delete(Integer id);
    
}
