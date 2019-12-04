package com.smi.innothink.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StudentPersonal")
public class StudentPersonal {
	

	
	@Id
	private String studentPersonalId;
	private String studentId;
	private String studentMobile;
	private String studentEmail;
	private String studentAddress;
	private String parentMobile;
	private String studentAlternateMobile;
	private String dateOfBirth;
	private String gender;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentPersonalId() {
		return studentPersonalId;
	}
	public void setStudentPersonalId(String studentPersonalId) {
		this.studentPersonalId = studentPersonalId;
	}
	public String getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(String studentMobile) {
		this.studentMobile = studentMobile;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getParentMobile() {
		return parentMobile;
	}
	public void setParentMobile(String parentMobile) {
		this.parentMobile = parentMobile;
	}
	public String getStudentAlternateMobile() {
		return studentAlternateMobile;
	}
	public void setStudentAlternateMobile(String studentAlternateMobile) {
		this.studentAlternateMobile = studentAlternateMobile;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
