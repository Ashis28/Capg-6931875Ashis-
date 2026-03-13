package com.capg.hospital.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capg.hospital.doctor.model.Doctor;
import com.capg.hospital.doctor.repository.DoctorRepository;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	DoctorRepository dr;
	
	@PostMapping("/add")
	public void add(@RequestBody Doctor doctor) {
		dr.save(doctor);
		
	}
	@GetMapping("/find/{id}")
	public Doctor find(@PathVariable int id) {
		return dr.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));

	}
	@RequestMapping("findAll")
	public List<Doctor> findAll(){
		return dr.findAll();
	}
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		dr.deleteById(id);
		return id+" Deletion done ";
	}
}
