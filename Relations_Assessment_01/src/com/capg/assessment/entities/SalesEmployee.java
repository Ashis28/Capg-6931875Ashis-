package com.capg.assessment.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class SalesEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long empid;
	private String name;
	private String department;
	
	@OneToMany(mappedBy="employee",cascade = CascadeType.ALL)
	private List<Lead> leads;
	
	public List<Lead> getLeads() {
		return leads;
	}
	public void setLeads(List<Lead> leads) {
		this.leads = leads;
	}
	public long getEmpid() {
		return empid;
	}
	public void setEmpid(long empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
