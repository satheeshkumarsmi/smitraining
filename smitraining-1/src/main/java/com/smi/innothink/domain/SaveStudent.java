package com.smi.innothink.domain;

public class SaveStudent {
	private Student student;
	private StudentPersonal studentPersonal;
	private AcademicDetails academicDetails;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public StudentPersonal getStudentPersonal() {
		return studentPersonal;
	}
	public void setStudentPersonal(StudentPersonal studentPersonal) {
		this.studentPersonal = studentPersonal;
	}
	public AcademicDetails getAcademicDetails() {
		return academicDetails;
	}
	public void setAcademicDetails(AcademicDetails academicDetails) {
		this.academicDetails = academicDetails;
	}

}
