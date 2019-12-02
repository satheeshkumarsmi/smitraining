package com.smi.innothink.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StudentPersonal")
public class StudentPersonal {
	@Id
	@Column(name = "StudentId")
	private int studentId;
	@Column(name = "PersonalId")
	private int personalId;
	@Column(name = "StudentMobile")
	private String studentMobile;
	@Column(name = "StudentEmail")
	private String studentEmail;
	@Column(name = "StudentAddress")
	private String studentAddress;
	@Column(name = "ParentMobile")
	private String parentMobile;
	@Column(name = "StudentAlternateMobile")
	private String studentAlternateMobile;
	@Column(name = "DateOfBirth")
	private String dateOfBirth;
	@Column(name = "Gender")
	private String gender;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getPersonalId() {
		return personalId;
	}
	public void setPersonalId(int personalId) {
		this.personalId = personalId;
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
