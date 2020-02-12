/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author tss
 */
public class App {
 
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        
        EntityManager em = emf.createEntityManager();
        
        List<Song> list = em.createQuery("select e from Song e order by e.artista", Song.class)
                .getResultList();
                
        list.forEach(v -> System.out.println(v.getTitolo()));

        em.getTransaction().begin();
        
            Song song1 = new Song("aa", "aa", "aa");
            
            em.persist(song1);

            /*
            errore in transaction
            
            Song song2 = new Song("qq", "qq", "qq");
            song2.setId(7l);               
            em.persist(song2);
            
            */
        em.getTransaction().commit();
        
        
    }
}
