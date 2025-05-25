package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ISongRepository;
import com.example.demo.service.to.SongTO;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    private ISongRepository songRepository;

    @Override
    public boolean insert(SongTO song) {
        try {
            this.songRepository.save(song.toSong());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public SongTO findById(Integer id) {
        try {
            return this.songRepository.findById(id).toTO();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<SongTO> findAll() {
        try {
            return this.songRepository.findAll().stream()
                    .map(song -> song.toTO())
                    .toList();
        } catch (Exception e) {
            return List.of();
        }
    }

    @Override
    public SongTO put(Integer id, SongTO song) {
        try {
            SongTO existingSong = this.songRepository.findById(id).toTO();
            if(song.getTitle() != null) {
                existingSong.setTitle(song.getTitle());
            }
            if(song.getDuration() != null) {
                existingSong.setDuration(song.getDuration());
            }
            if (song.getArtistId() != null) {
                existingSong.setArtistId(song.getArtistId());
            }
            return this.songRepository.put(existingSong.toSong()).toTO();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            this.songRepository.delete(id);
        } catch (Exception e) {
            System.out.println("Error deleting song: " + e.getMessage());
        }
    }
    
}
