package com.smi.innothink.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name="DailyStatus")
@NamedStoredProcedureQuery(name = "in_and_out_test_dailystatus", 
procedureName = "sample",
parameters = {
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "outParam1", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.OUT, name = "outParam2", type = String.class)
})
public class DailyStatus {
@Id
private String dailyStatusId;
private String batchId;
private String date;
private String courseId;
private String subjectId;
private String topicId;
private String trainerId;

public String getTrainerId() {
	return trainerId;
}

public void setTrainerId(String trainerId) {
	this.trainerId = trainerId;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getBatchId() {
	return batchId;
}

public void setBatchId(String batchId) {
	this.batchId = batchId;
}


public String getCourseId() {
	return courseId;
}

public void setCourseId(String courseId) {
	this.courseId = courseId;
}

public String getSubjectId() {
	return subjectId;
}

public void setSubjectId(String subjectId) {
	this.subjectId = subjectId;
}

public String getTopicId() {
	return topicId;
}

public void setTopicId(String topicId) {
	this.topicId = topicId;
}

public String getDailyStatusId() {
	return dailyStatusId;
}

public void setDailyStatusId(String dailyStatusId) {
	this.dailyStatusId = dailyStatusId;
}
	

}
