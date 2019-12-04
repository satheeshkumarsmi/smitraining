package com.smi.innothink.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="AcademicDetails")
public class AcademicDetails {
	@Id
	
	private String studentId;
	
	private String studentAcademicId;
	
	private String studentCollege;	
	
    private String	qualification;
	
	private String stream;
	
	private int yearOfPassing;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentAcademicId() {
		return studentAcademicId;
	}
	public void setStudentAcademicId(String studentAcademicId) {
		this.studentAcademicId = studentAcademicId;
	}
	public String getStudentCollege() {
		return studentCollege;
	}
	public void setStudentCollege(String studentCollege) {
		this.studentCollege = studentCollege;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public int getYearOfPassing() {
		return yearOfPassing;
	}
	public void setYearOfPassing(int yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

}

