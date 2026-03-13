package com.capg.assessment.serviceImpl;

import javax.persistence.EntityManager;

import com.capg.assessment.entities.SalesEmployee;
import com.capg.assessment.services.ReportService;

public class ReportServiceImpl implements ReportService {
    private EntityManager em;

    public ReportServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public String getEmployeePerformance(Long employeeId) {
        SalesEmployee emp = em.find(SalesEmployee.class, employeeId);
        if (emp == null) return "Employee not found";

        int leadCount = emp.getLeads() != null ? emp.getLeads().size() : 0;
        return "Employee " + emp.getName() + " handled " + leadCount + " leads.";
    }
}