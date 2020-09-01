package com.group2.FSD.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "credit_card")
public class CreditCard {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_entry_cr")
    @SequenceGenerator(sequenceName = "cr", allocationSize = 1, name = "sales_entry_cr")
	private Long creditId;
	private Long creditCardNum;
	private Date validity;
	

	
	public CreditCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getCreditId() {
		return creditId;
	}
	public Long getCreditCardNum() {
		return creditCardNum;
	}
	public void setCreditCardNum(Long creditCardNum) {
		this.creditCardNum = creditCardNum;
	}
	public Date getValidity() {
		return validity;
	}
	public void setValidity(Date validity) {
		this.validity = validity;
	}

	@Override
	public String toString() {
		return "CreditCard [creditId=" + creditId + ", creditCardNum=" + creditCardNum + ", validity=" + validity + "]";
	}
	
}
