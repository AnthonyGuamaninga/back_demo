package com.example.demo.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.example.demo.repository.model.Artist;

public class ArtistTO extends RepresentationModel<SongTO> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nationality;
    private String name;
    
    public Artist toArtist(){
        Artist artist = new Artist();
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
