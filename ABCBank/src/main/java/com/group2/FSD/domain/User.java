package com.group2.FSD.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userLogin")
public class User {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userid;
	private String password;
	private String usertype;
	public Integer getuserid() {
		return userid;
	}
	public void setuserid(Integer userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password + ", usertype=" + usertype + "]";
	}
	
	
	
	
}
