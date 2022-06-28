package com.example.HospitalManagementSystemApplication.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")

public class Appointment implements Serializable {


          @Id
          @GeneratedValue(strategy=GenerationType.AUTO)
         private long id;
         private String appointmentNo;
         private String patientName;
         private String gender;
         private long age;
         private String disease;
         private Date date;
         
         
         
         @OneToOne(mappedBy="appointment",cascade=CascadeType.PERSIST)
     	 @JsonIgnoreProperties("appointment")
         private Patient patient;
         
         @ManyToOne(fetch=FetchType.LAZY)
     	 @JsonIgnoreProperties("appointment")
         private Doctor doctor;
         
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getAppointmentNo() {
			return appointmentNo;
		}
		public void setAppointmentNo(String appointmentNo) {
			this.appointmentNo = appointmentNo;
		}
		public String getPatientName() {
			return patientName;
		}
		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public long getAge() {
			return age;
		}
		public void setAge(long age) {
			this.age = age;
		}
		public String getDisease() {
			return disease;
		}
		public void setDisease(String disease) {
			this.disease = disease;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public Patient getPatient() {
			return patient;
		}
		public void setPatient(Patient patient) {
			this.patient = patient;
		}
		public Doctor getDoctor() {
			return doctor;
		}
		public void setDoctor(Doctor doctor) {
			this.doctor = doctor;
		}
		public Appointment() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Appointment(long id, String appointmentNo, String patientName, String gender, long age, String disease,
				Date date, Patient patient, Doctor doctor) {
			super();
			this.id = id;
			this.appointmentNo = appointmentNo;
			this.patientName = patientName;
			this.gender = gender;
			this.age = age;
			this.disease = disease;
			this.date = date;
			this.patient = patient;
			this.doctor = doctor;
		}
		@Override
		public String toString() {
			return "Appointment [id=" + id + ", appointmentNo=" + appointmentNo + ", patientName=" + patientName
					+ ", gender=" + gender + ", age=" + age + ", disease=" + disease + ", date=" + date + ", patient="
					+ patient + ", doctor=" + doctor + "]";
		}
         
}
      
		