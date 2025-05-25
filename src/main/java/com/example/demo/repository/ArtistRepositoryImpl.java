package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Artist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ArtistRepositoryImpl implements IArtistRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(Artist artist) {
        try {
            entityManager.persist(artist);
            return true;
        } catch (Exception e) {
            System.out.println("Error saving artist: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Artist findById(Integer id) {
        try {
            return entityManager.find(Artist.class, id);
        } catch (Exception e) {
            System.out.println("Error finding artist by ID: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Artist> findAll() {
        try {
            return entityManager.createQuery("SELECT a FROM Artist a", Artist.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error finding all artists: " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public Artist put(Artist artist) {
        try {
            return entityManager.merge(artist);
        } catch (Exception e) {
            System.out.println("Error updating artist: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            Artist artist = entityManager.find(Artist.class, id);
            if (artist != null) {
                entityManager.remove(artist);
            }
        } catch (Exception e) {
            System.out.println("Error deleting artist: " + e.getMessage());
        }
    }
    
}
