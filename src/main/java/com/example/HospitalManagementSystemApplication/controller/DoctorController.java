package com.example.HospitalManagementSystemApplication.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.example.HospitalManagementSystemApplication.entity.Doctor;
import com.example.HospitalManagementSystemApplication.service.DoctorService;

@RestController
@RequestMapping("/api/doctor")

public class DoctorController {
		
		@Autowired
		DoctorService doctorService;
		@PostMapping
		public ResponseEntity<Doctor> saveDoctor(@Valid @RequestBody Doctor doctor)
		{
			return new ResponseEntity<Doctor>(doctorService.saveDoctor(doctor),HttpStatus.CREATED);
		}
		
		@GetMapping
		public List<Doctor> getDoctorList()
		{
			return doctorService.getDoctorList();
		}
		
		@GetMapping("/{id}")
		public Doctor getDoctorById(@PathVariable("id")long id) {
			return doctorService.getDoctorById(id);
			
		}

		
		@PutMapping("/{id}")
		public Doctor updateDoctor(@PathVariable("id")long id, @RequestBody Doctor doctor) {
			return doctorService.updateDoctor(id, doctor);
			
		}
		
		@DeleteMapping("/{id}")
		public String deleteDoctor(@PathVariable("id")long id) {
			return doctorService.deleteDoctor(id);
		}
		@GetMapping("/GetByFirstName/{firstName}")
		public List<Doctor> getDoctorByFirstName(@PathVariable("firstName") String firstName){
			return doctorService.getDoctorByFirstName(firstName);
		}
		@GetMapping("/GetByLastName/{lastName}")
		public List<Doctor> getEmployeeByLastName(@PathVariable("lastName") String lastName){
			return doctorService.getDoctorByLastName(lastName);
		}
		@GetMapping("/GetEmployeeByFullName/{firstName}/{lastName}")
		public List<Doctor> getDoctorByFullName(@PathVariable("firstName")String firstName,@PathVariable("lastName") String lastName){
			return doctorService.getDoctorByFullName(firstName , lastName);
		}
	}


