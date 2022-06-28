package com.example.HospitalManagementSystemApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.HospitalManagementSystemApplication.entity.Doctor;
import com.example.HospitalManagementSystemApplication.exception.LastNameNotFoundException;
import com.example.HospitalManagementSystemApplication.exception.NoRecordFoundException;
import com.example.HospitalManagementSystemApplication.exception.ResourceNotFoundException;
import com.example.HospitalManagementSystemApplication.repository.DoctorRepository;



@Service
public class DoctorServiceImpl implements DoctorService{
	
	DoctorRepository doctorRepository;
	
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}
	

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> getDoctorList() {
       List<Doctor> doctor =doctorRepository.findAll();
       if(doctor.isEmpty())
    	   throw new NoRecordFoundException();
       else
		return doctor;
	}

	@Override
	public Doctor getDoctorById(long id) {
    Optional<Doctor> doctor= doctorRepository.findById(id);
		
		if(doctor.isPresent())
			return doctor.get();
		else
			throw new ResourceNotFoundException("Doctor", "Id", id);
	}
	
	@Override
	public Doctor updateDoctor(long id, Doctor doctor) {
Doctor dr =doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor","Id",id));
		
		dr.setFirstName(doctor.getFirstName());
		dr.setLastName(doctor.getLastName());
		dr.setAddress(doctor.getAddress());
		dr.setContactNo(doctor.getContactNo());
		dr.setQualification(doctor.getQualification());
		dr.setGender(doctor.getGender());
		dr.setUserName(doctor.getUserName());
		dr.setPassword(doctor.getPassword());
		dr.setYearOfExperience(doctor.getYearOfExperience());
		dr.setSalary(doctor.getSalary());
		
		doctorRepository.save(dr);
		return dr;
	}
	
	@Override
	public String deleteDoctor(long id) {
		Doctor doctor=doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor","Id",id));
		doctorRepository.deleteById(id);;	
		return "Doctor Record Deleted Successfully";
		}


	@Override
	public List<Doctor> getDoctorByFirstName(String firstName) {
		
		return doctorRepository.getByFirstName(firstName);
	}


	@Override
	public List<Doctor> getDoctorByLastName(String lastName) {
		 List<Doctor> doctor =doctorRepository.getDoctorBylastName(lastName);
	       if(doctor.isEmpty())
	       {
	    	   throw new LastNameNotFoundException();
	       }
	       else
	       {
			return doctor;
		}
	}


	@Override
	public List<Doctor> getDoctorByFullName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
