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

import org.springframework.stereotype.Repository;
@Entity
@Table(name = "course")
@NamedStoredProcedureQuery(name = "in_and_out_test", 
procedureName = "sample",
parameters = {
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "outParam1", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.OUT, name = "outParam2", type = String.class)
})
public class Course {
	@Id
	
	private String courseID;
	@Column(name="course_name")
	private String CourseName;
	private String description;
	
	public String getCourseID() {
		
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		this.CourseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	

}