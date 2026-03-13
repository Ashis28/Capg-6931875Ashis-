package com.capg.hospital.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.hospital.doctor.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer>{

}
