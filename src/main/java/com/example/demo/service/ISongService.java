package com.example.demo.service;

import java.util.List;

import com.example.demo.service.to.SongTO;

public interface ISongService {

    public boolean insert(SongTO song);
	public SongTO findById(Integer id);
	public List<SongTO> findAll();
	public SongTO put(Integer id, SongTO song);
	public void delete(Integer cedula);
    
}
