package com.smi.innothink.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name="Student")
@NamedStoredProcedureQuery(name = "in_and_out_test_student", 
procedureName = "sample",
parameters = {
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "outParam1", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.OUT, name = "outParam2", type = String.class)
})
public class Student {
@Id
private String studentId;
private String studentName;
private String dateOfJoining;
private String bond;
private String studentMobile;
private String duration;
private String salary;
private String studentPersonalId;
@Column(name="stay_details")
private String stayDetails;
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
public String getStudentMobile() {
	return studentMobile;
}
public void setStudentMobile(String studentMobile) {
	this.studentMobile = studentMobile;
}
public String getBond() {
	return bond;
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
public String isBond() {
	return bond;
}
public void setBond(String bond) {
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