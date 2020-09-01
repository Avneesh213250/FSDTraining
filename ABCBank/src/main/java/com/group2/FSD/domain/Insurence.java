package com.group2.FSD.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "insurence")
public class Insurence {
    
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_entry_ins")
    @SequenceGenerator(sequenceName = "ins", allocationSize = 1, name = "sales_entry_ins")
	private Long insurenceId;
	private String insurence;
	private String policy;
	private Date matuityDate;
	

	
	public Insurence() {

	}

	public Long getInsurenceId() {
		return insurenceId;
	}
	
	public String getInsurence() {
		return insurence;
	}
	public void setInsurence(String insurence) {
		this.insurence = insurence;
	}
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	public Date getMatuityDate() {
		return matuityDate;
	}
	public void setMatuityDate(Date matuityDate) {
		this.matuityDate = matuityDate;
	}
	


	public Insurence(Long insurenceId, String insurence, String policy, Date matuityDate) {
		super();
		this.insurenceId = insurenceId;
		this.insurence = insurence;
		this.policy = policy;
		this.matuityDate = matuityDate;
	}

	@Override
	public String toString() {
		return "Insurence [insurenceId=" + insurenceId + ", insurence=" + insurence + ", policy=" + policy
				+ ", matuityDate=" + matuityDate + "]";
	}
	
}
