package com.example.HospitalManagementSystemApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HospitalManagementSystemApplication.entity.Patient;
import com.example.HospitalManagementSystemApplication.exception.ResourceNotFoundException;
import com.example.HospitalManagementSystemApplication.repository.PatientRepository;


@Service

public class PatientServiceImpl implements PatientService{
	

	@Autowired
	PatientRepository patientRepository;


	@Override
	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> getPatientList() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	
	}

	@Override
	public Patient getPatientById(long id) {
		// TODO Auto-generated method stub
    Patient patient=patientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient","id",id));
		
		return patient;
		
	}

	@Override
	public Patient updatePatient(long id, Patient patient) {
		// TODO Auto-generated method stub
		
				Patient patient1=patientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient","id",id));
		         patient1.setFirstName(patient.getFirstName());
		         patient1.setMiddleName(patient.getMiddleName());
		         patient1.setLastName(patient.getLastName());
		         patient1.setAge(patient.getAge());
		         patient1.setGender(patient.getGender());
		         patient1.setAddress(patient.getAddress());
		         patient1.setContactno(patient.getContactno());
		         patient1.setDate(patient.getDate());
		         patient1.setUserName(patient.getUserName());
		         patient1.setPassword(patient.getPassword());
		        
		         patientRepository.save(patient1);
				return patient1;
			}



	@Override
	public String deletePatient(long id) {
		Patient patient=patientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient","id",id));
		patientRepository.deleteById(id);
		return "Patient record deleted successfully..";
	}

}
