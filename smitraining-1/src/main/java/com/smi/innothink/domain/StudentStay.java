package com.smi.innothink.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StudentStay")
public class StudentStay {

	@Id
	@Column(name = "StayId")
	private int stayId;
	@Column(name = "Details")
	private String details;
	public int getStayId() {
		return stayId;
	}
	public void setStayId(int stayId) {
		this.stayId = stayId;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}


}