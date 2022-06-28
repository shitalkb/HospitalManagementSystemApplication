package com.example.HospitalManagementSystemApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HospitalManagementSystemApplication.entity.Patient;
import com.example.HospitalManagementSystemApplication.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

	
	@Autowired
	PatientService patientService;
	@PostMapping
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient)
	{
		return new ResponseEntity<Patient>(patientService.savePatient(patient),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Patient> getPatientList(){
		return patientService.getPatientList();
	}
	
	@GetMapping("/{id}")
	public Patient getPatientById(@PathVariable("id")long id) {
		return patientService.getPatientById(id);
		
	}
	
	@PutMapping("/{id}")
	public Patient updatePatient(@PathVariable("id") long id, @RequestBody Patient patient) {
	
		return patientService.updatePatient(id,patient);
	}
	
	@DeleteMapping("/{id}")
	public String deletePatient(@PathVariable("id") long id) {
		return patientService.deletePatient(id);
		
	}
}


