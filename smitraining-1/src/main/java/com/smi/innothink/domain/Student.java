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
private int studentPersonalId;
private int stayId;
private int statusId;
private int academicId;
private int modeId;
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
public int getStudentPersonalId() {
	return studentPersonalId;
}
public void setStudentPersonalId(int studentPersonalId) {
	this.studentPersonalId = studentPersonalId;
}
public int getStayId() {
	return stayId;
}
public void setStayId(int stayId) {
	this.stayId = stayId;
}
public int getStatusId() {
	return statusId;
}
public void setStatusId(int statusId) {
	this.statusId = statusId;
}
public int getAcademicId() {
	return academicId;
}
public void setAcademicId(int academicId) {
	this.academicId = academicId;
}
public int getModeId() {
	return modeId;
}
public void setModeId(int modeId) {
	this.modeId = modeId;
}

}