package com.company;

import com.company.music.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        try (var sessionFactory = Persistence.createEntityManagerFactory("com.company.Music");
            EntityManager entityManager = sessionFactory.createEntityManager();) {

            var transaction = entityManager.getTransaction();
            transaction.begin();
            Artist artist = entityManager.find(Artist.class, 202);
            artist.setArtistName("Muddy Waters");
//            Artist artist = new Artist(202, "Muddy Water");
            System.out.println(artist);
//            entityManager.persist(new Artist("Muddy Water"));
//            entityManager.remove(artist);
//            entityManager.merge(artist);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
