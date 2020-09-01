package com.group2.FSD.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sales_type", schema = "master")
public class SalesType {

	@Id
	private int id;
	@Column(name = "sales_type")
	private String type;
	
	
	public SalesType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSalesType() {
		return type;
	}
	public void setSalesType(String salestype) {
		this.type = salestype;
	}
	

}
