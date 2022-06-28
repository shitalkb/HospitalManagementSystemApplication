package com.example.HospitalManagementSystemApplication.service;

import java.util.List;

import com.example.HospitalManagementSystemApplication.entity.Appointment;

public interface AppointmentService {

	Appointment saveAppointment(Appointment appointment);

	List<Appointment> getAppointmentList();

	Appointment updateAppointment(long id, Appointment appointment);

	String deleteAppointment(long id);

}
