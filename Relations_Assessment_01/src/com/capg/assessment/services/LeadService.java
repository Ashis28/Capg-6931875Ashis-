package com.capg.assessment.services;

import com.capg.assessment.entities.Customer;
import com.capg.assessment.entities.Lead;

public interface LeadService {
	Lead createLead(String name, String source, String contactInfo);
    Lead assignLeadToEmployee(Long leadId, Long employeeId);
    Customer convertLeadToCustomer(Long leadId);
}
