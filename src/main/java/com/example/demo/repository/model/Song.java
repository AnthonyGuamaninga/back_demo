package com.example.demo.repository.model;

import java.time.Duration;

import com.example.demo.service.to.SongTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "song")
public class Song {

    @Id
	@Column(name = "song_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "song_id_seq")
	@SequenceGenerator(name = "song_id_seq", sequenceName = "song_id_seq", allocationSize = 1, initialValue = 1)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "duration")
    private Duration duration;
    @Column(name = "id_artist")
    private Integer artistId;

    public SongTO toTO() {
        SongTO songTO = new SongTO();
        songTO.setId(this.id);
        songTO.setTitle(this.title);
        songTO.setDuration(this.duration);
        songTO.setArtistId(this.artistId);
        return songTO;
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
