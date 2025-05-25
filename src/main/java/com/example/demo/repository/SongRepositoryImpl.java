package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Song;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SongRepositoryImpl implements ISongRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(Song song) {
        System.out.println("Saving song: " + song.getArtistId());
        try {
            entityManager.persist(song);
            return true;
        } catch (Exception e) {
            System.out.println("Error saving song: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Song findById(Integer id) {
        try {
            return entityManager.find(Song.class, id);
        } catch (Exception e) {
            System.out.println("Error finding song by ID: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Song> findAll() {
        try {
            return entityManager.createQuery("SELECT s FROM Song s", Song.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error finding all songs: " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public Song put(Song song) {
        try {
            return entityManager.merge(song);
        } catch (Exception e) {
            System.out.println("Error updating song: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            Song song = entityManager.find(Song.class, id);
            if (song != null) {
                entityManager.remove(song);
            }
        } catch (Exception e) {
            System.out.println("Error deleting song: " + e.getMessage());
        }
    }
    
}
