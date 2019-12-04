package com.smi.innothink.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "BatchStatus")
public class BatchStatus {
	@Id
	private String batchStatusId;
	private String studentStatus;
	public String getBatchStatusId() {
		return batchStatusId;
	}
	public void setBatchStatusId(String batchStatusId) {
		this.batchStatusId = batchStatusId;
	}
	public String getStudentStatus() {
		return studentStatus;
	}
	public void setStudentStatus(String studentStatus) {
		this.studentStatus = studentStatus;
	}
}