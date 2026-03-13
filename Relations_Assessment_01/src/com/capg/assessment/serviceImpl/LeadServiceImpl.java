package com.capg.assessment.serviceImpl;

import javax.persistence.EntityManager;

import com.capg.assessment.entities.Customer;
import com.capg.assessment.entities.Lead;
import com.capg.assessment.entities.SalesEmployee;
import com.capg.assessment.services.LeadService;

public class LeadServiceImpl implements LeadService {
    private EntityManager em;

    public LeadServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Lead createLead(String name, String source, String contactInfo) {
        Lead lead = new Lead();
        lead.setSource(source);
        lead.setStatus("NEW");

        em.getTransaction().begin();
        em.persist(lead);
        em.getTransaction().commit();

        return lead;
    }

    @Override
    public Lead assignLeadToEmployee(Long leadId, Long employeeId) {
        em.getTransaction().begin();
        Lead lead = em.find(Lead.class, leadId);
        SalesEmployee emp = em.find(SalesEmployee.class, employeeId);
        lead.setEmployee(emp);
        em.merge(lead);
        em.getTransaction().commit();
        return lead;
    }

    @Override
    public Customer convertLeadToCustomer(Long leadId) {
        em.getTransaction().begin();
        Lead lead = em.find(Lead.class, leadId);
        Customer customer = new Customer();
        customer.setName("Converted Lead");
        customer.setEmail("lead@example.com");
        customer.setPhone("0000000000");
        em.persist(customer);
        em.getTransaction().commit();
        return customer;
    }
}
