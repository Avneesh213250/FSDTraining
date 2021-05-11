package com.group2.FSD.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;



@Entity
@SequenceGenerator(sequenceName = "ra", allocationSize = 1, name = "stu_sq", initialValue = 1023)
public class StudentDetails {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stu_sq")
	private Integer id;
	private String firstName;
	private String lastName;
	private String usn;
	private String branch;
	private String marksObtainsOutOf;
	private String mobileNumber;
	private String emailId;
	
	
	public StudentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getMarksObtainsOutOf() {
		return marksObtainsOutOf;
	}
	public void setMarksObtainsOutOf(String marksObtainsOutOf) {
		this.marksObtainsOutOf = marksObtainsOutOf;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", usn=" + usn
				+ ", branch=" + branch + ", marksObtainsOutOf=" + marksObtainsOutOf + ", mobileNumber=" + mobileNumber
				+ ", emailId=" + emailId + "]";
	}
	
	
}
