package com.smi.innothink.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name="MarkUpdates")
@NamedStoredProcedureQuery(name = "in_and_out_test_markupdates", 
procedureName = "sample",
parameters = {
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "outParam1", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.OUT, name = "outParam2", type = String.class)
})
public class MarkUpdates {
	@Id
	private String markUpdatesId;
	private String assignAssesmentId;
	private double totalMarks;
	private double marksObtained;
	private String studentId;
	public double getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(double totalMarks) {
		this.totalMarks = totalMarks;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getMarkUpdatesId() {
		return markUpdatesId;
	}
	public void setMarkUpdatesId(String markUpdatesId) {
		this.markUpdatesId = markUpdatesId;
	}
	public String getAssignAssesmentId() {
		return assignAssesmentId;
	}
	public void setAssignAssesmentId(String assignAssesmentId) {
		this.assignAssesmentId = assignAssesmentId;
	}
	public double getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(double marksObtained) {
		this.marksObtained = marksObtained;
	}
	

}
