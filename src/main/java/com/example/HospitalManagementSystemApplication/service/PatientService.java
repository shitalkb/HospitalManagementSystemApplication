package com.example.HospitalManagementSystemApplication.service;

import java.util.List;

import com.example.HospitalManagementSystemApplication.entity.Patient;

public interface PatientService {

	Patient savePatient(Patient patient);

	List<Patient> getPatientList();

	Patient getPatientById(long id);

	Patient updatePatient(long id, Patient patient);

	String deletePatient(long id);

}
