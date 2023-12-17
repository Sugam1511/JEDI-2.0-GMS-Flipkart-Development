package com.flipkart.bean;


public class User {
	
	private int userId;
	private String name;
	private String phoneNo;
	private String password;
	private String emailId;
	private String roleName;
	



	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public User(String email, String password2, String rolename) {
		this.emailId = email;
		this.password = password2;
		this.roleName = rolename;
		// TODO Auto-generated constructor stub
	}
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
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
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
