package com.smi.innothink.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StudentStatus")
public class StudentStatus {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int studentId;
private String status;
public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
