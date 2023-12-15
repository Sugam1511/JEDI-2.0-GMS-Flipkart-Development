package com.flipkart.business;
import java.util.*;

import com.flipkart.DAO.AdminDAOImpl;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;

public class AdminBusiness implements AdminBusinessInterface{
	AdminDAOImpl adminDAO = new AdminDAOImpl();
	
	public List<GymOwner> getGymOwners() {
		return adminDAO.getAllGymOwners();
	}
	
	public List<GymCentre> getGym() {
		return adminDAO.getAllGyms();
	}

	public List<GymOwner> viewAllPendingGymOwnerRequests() {
		return adminDAO.getPendingGymOwnerRequests();
	}

	
	public void approveSingleGymOwnerRequest(String gymOwnerEmail) {
		
	}

	
	public void approveAllPendingGymOwnerRequests() {
		
	}
	
	public List<GymCentre> viewAllPendingGymRequests() {
		return adminDAO.getPendingGymRequests();
	}
	
	public void approveSingleGymRequest(String gymId){
		
	}
	
	public void approveAllPendingGymRequests() {
		
	}
}