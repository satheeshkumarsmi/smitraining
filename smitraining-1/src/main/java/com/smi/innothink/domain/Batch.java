package com.smi.innothink.domain;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = " Batch")
public class Batch {
	@Id

	private String batchId;
	
	private String batchName;
	
	private String courseId;
	
	private String batchStatusId;
	
	private String batchCreatedDate;
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getBatchStatusId() {
		return batchStatusId;
	}
	public void setBatchStatusId(String batchStatusId) {
		this.batchStatusId = batchStatusId;
	}
	public String getBatchCreatedDate() {
		return batchCreatedDate;
	}
	public void setBatchCreatedDate(String batchCreatedDate) {
		this.batchCreatedDate = batchCreatedDate;
	}
}
