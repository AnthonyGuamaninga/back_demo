package com.example.demo.repository.model;

import java.time.Duration;

import com.example.demo.service.to.ArtistTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "artist")
public class Artist {
    
    @Id
	@Column(name = "arti_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "arti_id_seq")
	@SequenceGenerator(name = "arti_id_seq", sequenceName = "arti_id_seq", allocationSize = 1, initialValue = 1)
    private Integer id;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "name")
    private String name;
    
    public ArtistTO toTO(){
        ArtistTO artist = new ArtistTO();
        artist.setId(this.id);
        artist.setNationality(this.nationality);
        artist.setName(this.name);
        return artist;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    

}
