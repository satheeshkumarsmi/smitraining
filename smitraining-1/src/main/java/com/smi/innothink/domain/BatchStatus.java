package com.smi.innothink.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
@Entity
@Table(name = "BatchStatus")
@NamedStoredProcedureQuery(name = "in_and_out_test_batchstatus", 
procedureName = "sample",
parameters = {
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "outParam1", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.OUT, name = "outParam2", type = String.class)
})
public class BatchStatus {
	@Id
	private String batchStatusId;
	private String batchStatus;
	public String getBatchStatusId() {
		return batchStatusId;
	}
	public void setBatchStatusId(String batchStatusId) {
		this.batchStatusId = batchStatusId;
	}
	public String getStudentStatus() {
		return batchStatus;
	}
	public void setStudentStatus(String batchStatus) {
		this.batchStatus = batchStatus;
	}
}