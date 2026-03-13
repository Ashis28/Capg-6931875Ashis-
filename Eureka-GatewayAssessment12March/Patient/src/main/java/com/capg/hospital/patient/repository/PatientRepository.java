package com.capg.hospital.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.hospital.patient.model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer>{

}
