package com.smi.innothink.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Attendance")
public class Attendance {
	@Id
	private String attendanceId;
	private String batchId;
	private String studentId;
	private String attendanceDate;
	private String forenoonSession;
	private String afternoonSession;
	public String getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(String attendanceId) {
		this.attendanceId = attendanceId;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	public String getForenoonSession() {
		return forenoonSession;
	}
	public void setForenoonSession(String forenoonSession) {
		this.forenoonSession = forenoonSession;
	}
	public String getAfternoonSession() {
		return afternoonSession;
	}
	public void setAfternoonSession(String afternoonSession) {
		this.afternoonSession = afternoonSession;
	}
	

}
