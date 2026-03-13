package com.capg.assessment.serviceImpl;

import javax.persistence.EntityManager;

import com.capg.assessment.entities.Product;
import com.capg.assessment.services.ProductService;

public class ProductServiceImpl implements ProductService {
    private EntityManager em;

    public ProductServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Product addProduct(String name, double price) {
        Product product = new Product();
        product.setProductName(name);
        product.setPrice(price);

        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();

        return product;
    }
}
