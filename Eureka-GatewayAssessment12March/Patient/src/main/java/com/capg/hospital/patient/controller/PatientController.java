package com.capg.hospital.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hospital.patient.model.Patient;
import com.capg.hospital.patient.repository.PatientRepository;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	PatientRepository pr;
	
	@PostMapping("/add")
	public void add(@RequestBody Patient patient) {
		pr.save(patient);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Patient> find(@PathVariable int id) {
	    return pr.findById(id)
	            .map(ResponseEntity::ok)
	            .orElse(ResponseEntity.notFound().build());
	}
	@RequestMapping("/findAll")
	public List<Patient> findAll(){
		return pr.findAll();
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		pr.deleteById(id);
		return id + " :Deleted success";
	}
}
