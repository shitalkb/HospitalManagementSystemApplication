package com.example.HospitalManagementSystemApplication.service;

import java.util.List;

import com.example.HospitalManagementSystemApplication.entity.Doctor;

public interface DoctorService {

	Doctor saveDoctor(Doctor doctor);

	List<Doctor> getDoctorList();

	Doctor getDoctorById(long id);

	Doctor updateDoctor(long id, Doctor doctor);

	String deleteDoctor(long id);

	List<Doctor> getDoctorByFirstName(String firstName);

	List<Doctor> getDoctorByLastName(String lastName);

	List<Doctor> getDoctorByFullName(String firstName, String lastName);

		
	}

