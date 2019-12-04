package com.smi.innothink.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
@Id
private String studentId;
private String studentName;
private String dateOfJoining;
private boolean bond;
private String duration;
private String salary;
private String studentPersonalId;
private String stayDetails;
private String statusDetails;
private String academicId;
private String mode;
public String getStudentId() {
	return studentId;
}
public void setStudentId(String studentId) {
	this.studentId = studentId;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getDateOfJoining() {
	return dateOfJoining;
}
public void setDateOfJoining(String dateOfJoining) {
	this.dateOfJoining = dateOfJoining;
}
public boolean isBond() {
	return bond;
}
public void setBond(boolean bond) {
	this.bond = bond;
}
public String getDuration() {
	return duration;
}
public void setDuration(String duration) {
	this.duration = duration;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public String getStudentPersonalId() {
	return studentPersonalId;
}
public void setStudentPersonalId(String studentPersonalId) {
	this.studentPersonalId = studentPersonalId;
}
public String getStayDetails() {
	return stayDetails;
}
public void setStayDetails(String stayDetails) {
	this.stayDetails = stayDetails;
}
public String getStatusDetails() {
	return statusDetails;
}
public void setStatusDetails(String statusDetails) {
	this.statusDetails = statusDetails;
}
public String getAcademicId() {
	return academicId;
}
public void setAcademicId(String academicId) {
	this.academicId = academicId;
}
public String getMode() {
	return mode;
}
public void setMode(String mode) {
	this.mode = mode;
}

}