package com.capg.assessment.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Lead {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long leadId;
	private String source;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private SalesEmployee employee;
	
	public SalesEmployee getEmployee() {
		return employee;
	}
	public void setEmployee(SalesEmployee employee) {
		this.employee = employee;
	}
	public long getLeadId() {
		return leadId;
	}
	public void setLeadId(long leadId) {
		this.leadId = leadId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
