package com.example.HospitalManagementSystemApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HospitalManagementSystemApplication.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

	List<Doctor> getByFirstName(String firstName);

	List<Doctor> getDoctorBylastName(String lastName);

}
