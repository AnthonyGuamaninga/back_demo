package com.example.demo.service;

import com.example.demo.service.to.ArtistTO;

public interface IArtistService {
 
    public boolean insert(ArtistTO artist);
	public ArtistTO findById(Integer id);
	public ArtistTO put(Integer id, ArtistTO artist);
	public void delete(Integer cedula);

}
