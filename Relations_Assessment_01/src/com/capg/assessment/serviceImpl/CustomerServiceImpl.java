package com.capg.assessment.serviceImpl;

import javax.persistence.EntityManager;

import com.capg.assessment.entities.Address;
import com.capg.assessment.entities.Customer;
import com.capg.assessment.services.CustomerSerivce;

public class CustomerServiceImpl implements CustomerSerivce {
    private EntityManager em;

    public CustomerServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Customer registerCustomer(String name, String email, String phone) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);

        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();

        return customer;
    }

    @Override
    public Customer addAddressToCustomer(Long customerId, Address address) {
        em.getTransaction().begin();
        Customer customer = em.find(Customer.class, customerId);
        em.persist(address);
        customer.setAddress(address);
        em.merge(customer);
        em.getTransaction().commit();
        return customer;
    }
}