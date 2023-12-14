package com.flipkart.bean;

import java.util.ArrayList;

public class GymOwner extends User{
	private String gstNo;
	private Boolean isApproved;
	private String address;
	private ArrayList<Integer> centreList;
	
	public ArrayList<Integer> getCentreList() {
		return centreList;
	}
	public void setCentreList(ArrayList<Integer> centreList) {
		this.centreList = centreList;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public Boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
