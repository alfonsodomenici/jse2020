/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.jpa;

import it.tss.jpa.entities.Categories;
import it.tss.jpa.entities.Products;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Categories found = em.find(Categories.class, 1);

        found.setDescription(found.getDescription() + " " + "limoncello");

        found = em.merge(found);

        em.getTransaction().commit();

        List<Categories> categories
                = em.createQuery("select distinct e from Categories e JOIN FETCH e.productsCollection p where p.productName= :pname order by e.categoryName", Categories.class)
                        .setParameter("pname", "tofu")
                        .getResultList();

        categories.forEach(v -> {
            System.out.println("--------------" + v.getCategoryName() + "-------------");
            v.getProductsCollection().forEach(p -> System.out.println(p.getProductName()));
        });

        em.createNamedQuery(Categories.FIND_ALL)
                .getResultList()
                .forEach(System.out::println);

        List<Products> products = em.createNamedQuery("Products.findAll", Products.class)
                .getResultList();

        for (Products p : products) {
            System.out.println(p);
        }

    }
}
