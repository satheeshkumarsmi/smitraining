package com.smi.innothink.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StudentStay")
public class StudentStay {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int stayId;
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