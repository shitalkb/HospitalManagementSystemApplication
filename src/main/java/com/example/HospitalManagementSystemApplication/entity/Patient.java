package com.example.HospitalManagementSystemApplication.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Patient implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String patientId;
	private String firstName;
	private String middleName;
	private String lastName;
	private int age;
	private String gender;
	private String address;
	private String contactno;
	private Date date;
	private String userName;
	private String password;
	
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="doctorId")
	@JsonIgnoreProperties({"patient","userName","password"})
    private Doctor doctor;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties("doctor")
	private Appointment appointment;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(long id, String patientId, String firstName, String middleName, String lastName, int age,
			String gender, String address, String contactno, Date date, String userName, String password, Doctor doctor,
			Appointment appointment) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.contactno = contactno;
		this.date = date;
		this.userName = userName;
		this.password = password;
		this.doctor = doctor;
		this.appointment = appointment;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", patientId=" + patientId + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", contactno=" + contactno + ", date=" + date + ", userName=" + userName + ", password=" + password
				+ ", doctor=" + doctor + ", appointment=" + appointment + "]";
	}
}
	