package com.smi.innothink.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Stream")
public class Stream {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SId")
	private int sId;
	@Column(name = "DegreeStream")
	private int degreeStream;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public int getDegreeStream() {
		return degreeStream;
	}
	public void setDegreeStream(int degreeStream) {
		this.degreeStream = degreeStream;
	}
	
}
