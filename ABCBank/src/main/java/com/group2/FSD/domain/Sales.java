package com.group2.FSD.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "sales_entry")
@SequenceGenerator(sequenceName = "sa", allocationSize = 1, name = "sales_entry_sq")
public class Sales {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_entry_sq")
    private Integer id;
	private String customername;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CreditCard creditCard;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Insurence insurence;
	
	private int salesId;
		
	@Transient
	private String salestype;
	
	private Date createdDate;
	private String createdBy;
	private Integer officerid;
	public Sales() {

	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public CreditCard getCreditCard() {
		return creditCard;
	}



	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}



	public Insurence getInsurence() {
		return insurence;
	}



	public void setInsurence(Insurence insurence) {
		this.insurence = insurence;
	}



	public int getSalesId() {
		return salesId;
	}



	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}



	public String getsalestype() {
		return salestype;
	}



	public void setsalestype(String salestype) {
		this.salestype = salestype;
	}



	public Integer getOfficerid() {
		return officerid;
	}



	public void setOfficerid(Integer officerid) {
		this.officerid = officerid;
	}



	@Override
	public String toString() {
		return "Sales [id=" + id + ", customername=" + customername + ", creditCard=" + creditCard + ", insurence="
				+ insurence + ", salesId=" + salesId + ", salestype=" + salestype + ", createdDate=" + createdDate
				+ ", createdBy=" + createdBy + ", officerid=" + officerid + "]";
	}
	
	
	
}
