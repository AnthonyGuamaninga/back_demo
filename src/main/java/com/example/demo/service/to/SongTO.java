package com.example.demo.service.to;

import java.io.Serializable;
import java.time.Duration;

import org.springframework.hateoas.RepresentationModel;

import com.example.demo.repository.model.Song;

public class SongTO extends RepresentationModel<SongTO> implements Serializable {

    private static final long serialVersionUID = 1L;
    Integer id;
    String title;
    Duration duration;
    Integer artistId;

    public Song toSong(){
        Song song = new Song();
        song.setId(this.id);
        song.setTitle(this.title);
        song.setDuration(this.duration);
        song.setArtistId(this.artistId);
        return song;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Integer getArtistId() {
        return artistId;
    }
    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }
    
}
