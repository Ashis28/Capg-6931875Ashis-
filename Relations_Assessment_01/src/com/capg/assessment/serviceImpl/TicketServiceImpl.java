package com.capg.assessment.serviceImpl;

import javax.persistence.EntityManager;

import com.capg.assessment.entities.Order;
import com.capg.assessment.entities.SupportTicket;
import com.capg.assessment.services.TickerService;

public class TicketServiceImpl implements TickerService {
    private EntityManager em;

    public TicketServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public SupportTicket raiseTicket(Long orderId, String issueDescription) {
        em.getTransaction().begin();
        Order order = em.find(Order.class, orderId);

        SupportTicket ticket = new SupportTicket();
        ticket.setOrder(order);
        ticket.setIssue(issueDescription);
        ticket.setStatus("OPEN");

        em.persist(ticket);
        em.getTransaction().commit();
        return ticket;
    }
}
