package com.example.HospitalManagementSystemApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HospitalManagementSystemApplication.entity.Appointment;


public interface AppointmentRepository  extends JpaRepository<Appointment,Long> {

}
