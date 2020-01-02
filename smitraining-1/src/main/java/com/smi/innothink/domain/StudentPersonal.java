package com.smi.innothink.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "StudentPersonal")
@NamedStoredProcedureQuery(name = "in_and_out_test_studentpersonal", 
procedureName = "sample",
parameters = {
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "outParam1", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.OUT, name = "outParam2", type = String.class)
})
public class StudentPersonal {	
	@Id
	private String studentPersonalId;	
	
    private String studentAddress;
	private String parentMobile;
	private String studentAlternateMobile;
	private String dateOfBirth;
	private String gender;
	
	public String getStudentPersonalId() {
		return studentPersonalId;
	}
	public void setStudentPersonalId(String studentPersonalId) {
		this.studentPersonalId = studentPersonalId;
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
