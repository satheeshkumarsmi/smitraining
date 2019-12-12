package com.smi.innothink.domain;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;


@Entity
@Table(name="Trainers")
@NamedStoredProcedureQuery(name = "in_and_out_test_trainer", 
procedureName = "sample",
parameters = {
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam2", type = String.class),
   @StoredProcedureParameter(mode = ParameterMode.OUT, name = "outParam2", type = String.class)
})
public class Trainers {
	@Id
	
	private String trainerId;
	private String trainerName;
	private String mobile;
	private String mailId;
	private String trainerQualification;
	private String technologyUndertaken;
	private String trainerPassword;
	

	
//	private List<SmiRoles> roles;
	
	
	public Trainers(Trainers trainer) {
		// TODO Auto-generated constructor stub
	}
	
	public String getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getTrainerQualification() {
		return trainerQualification;
	}
	public void setTrainerQualification(String trainerQualification) {
		this.trainerQualification = trainerQualification;
	}
	public String getTechnologyUndertaken() {
		return technologyUndertaken;
	}
	public void setTechnologyUndertaken(String technologyUndertaken) {
		this.technologyUndertaken = technologyUndertaken;
	}
	public String getTrainerPassword() {
		return trainerPassword;
	}
	public void setTrainerPassword(String trainerPassword) {
		this.trainerPassword = trainerPassword;
	}

}
