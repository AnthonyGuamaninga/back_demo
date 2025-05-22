package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IArtistRepository;
import com.example.demo.service.to.ArtistTO;
import com.example.demo.service.to.ArtistTO;

@Service
public class ArtistServiceImpl implements IArtistService {

    @Autowired
    private IArtistRepository artistRepository;

    @Override
    public boolean insert(ArtistTO artist) {
        try {
            this.artistRepository.save(artist.toArtist());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ArtistTO findById(Integer id) {
        try {
            return this.artistRepository.findById(id).toTO();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArtistTO put(Integer id, ArtistTO artist) {
        try {
            ArtistTO existingArtist = this.artistRepository.findById(id).toTO();
            if(artist.getName() != null) {
                existingArtist.setName(artist.getName());
            }
            if(artist.getNationality() != null) {
                existingArtist.setNationality(artist.getNationality());
            }
            return this.artistRepository.put(existingArtist.toArtist()).toTO();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            this.artistRepository.delete(id);
        } catch (Exception e) {
            System.out.println("Error deleting artist: " + e.getMessage());
        }
    }
}
