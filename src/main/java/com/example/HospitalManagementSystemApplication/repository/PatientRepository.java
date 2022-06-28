package com.example.HospitalManagementSystemApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HospitalManagementSystemApplication.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {

}
