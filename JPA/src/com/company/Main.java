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
            Artist artist = entityManager.find(Artist.class, 201);
            System.out.println(artist);
            artist.removeDuplicates();
            System.out.println(artist);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
