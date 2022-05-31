package com.cg.deptemp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name = "name", length = 30)
	private String name;
	@Column(name = "userName", length = 20)
	private String userName;
	@Column(name = "password", length = 30)
	private String password;
	@Column(name = "dateOfBirth", columnDefinition = "date")
	private Date dateOfBirth;
	@Column(name = "mobile", length = 10)
	private long mobile;
	@Column(name = "mailId", length = 30)
	private String mailId;
	@Column(name = "userType", length = 15)
	private String userType;
	@JoinColumn(name = "addressid")
	private Address address;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
