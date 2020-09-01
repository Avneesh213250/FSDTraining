package com.group2.FSD.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "Officer_Table")
@SequenceGenerator(sequenceName = "officer", allocationSize = 1, name = "sales_entry_off")
public class Officer {
	@Column(name = "Branch_Id")
	private String Branch_Id;
	@Column(name = "Officer_Id")
	@Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_entry_off")
	private Integer officerId;
	@Column(name = "Name")
	private  String officerName;
	@Column(name = "PhoneNumber")
	private String phoneNum;
	@Column(name = "Email")
	private String officerEmail;
	@Column(name = "Address")
	private String officerAdress;
	@Column(name = "Status")
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBranch_Id() {
		return Branch_Id;
	}
	public void setBranch_Id(String branch_Id) {
		Branch_Id = branch_Id;
	}
	public String getOfficerName() {
		return officerName;
	}
	public void setOfficerName(String officerName) {
		this.officerName = officerName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getOfficerEmail() {
		return officerEmail;
	}
	public void setOfficerEmail(String officerEmail) {
		this.officerEmail = this.officerName+"@fsdbank.com";
	}
	public String getOfficerAdress() {
		return officerAdress;
	}
	public void setOfficerAdress(String officerAdress) {
		this.officerAdress = officerAdress;
	}
	public Integer getOfficerId() {
		return officerId;
	}
	public void setOfficerId(Integer officerId) {
		this.officerId = officerId;
	}
	
	@Override
    public String toString() {
        return "OfficerEntity [id=" + officerId.toString() + ", Name=" + officerName + 
                ", Address=" + officerAdress + ", email=" + officerEmail  +  ", PhoneNO=" + phoneNum + ", Branch" + Branch_Id + "]";
    }

}
