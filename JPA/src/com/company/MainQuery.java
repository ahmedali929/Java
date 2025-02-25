package com.company;

import com.company.music.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainQuery {

    public static void main(String[] args) {

        List<Artist> artists = null;
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.company.music");
             EntityManager em = emf.createEntityManager();) {

            var transaction = em.getTransaction();
            transaction.begin();
            artists = getArtistsJPQL(em, "%Stev%");
            artists.forEach(System.out::println);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static List<Artist> getArtistsJPQL(EntityManager em, String matchedValue) {

        String jpql = "SELECT a FROM Artist a WHERE a.artistName LIKE :partialName";
        var query = em.createQuery(jpql, Artist.class);
        query.setParameter("partialName", matchedValue);
        return query.getResultList();
    }

}
