package com.flipkart.business;
import java.util.*;

import com.flipkart.DAO.AdminDAOImpl;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;

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

	
	public void approveSingleGymOwnerRequest(String gymOwnerEmail) throws GymOwnerNotFoundException {
		int approvedCount = adminDAO.approveSingleOwnerRequest(gymOwnerEmail);
		if (approvedCount == 0)
			throw new GymOwnerNotFoundException();
		System.out.println("\nApproved " + gymOwnerEmail + "!");
	}

	
	public void approveAllPendingGymOwnerRequests() {
		int approvedCount = adminDAO.approveAllOwnerRequest();
		if (approvedCount == 0)
			System.out.println("No pending Gym Owner Requests");
		else
			System.out.println("Approved all pending gym owner requests!");
	}
	
	public List<GymCentre> viewAllPendingGymRequests() {
		return adminDAO.getPendingGymRequests();
	}
	
	public void approveSingleGymRequest(String gymId) {
		int approvedCount = adminDAO.approveSingleGymRequest(gymId);
		System.out.println("\nSuccessfully approved gym " + gymId + "!");
	}
	
	public void approveAllPendingGymRequests() {
		int approvedCount = adminDAO.approveAllGymRequest();
		if (approvedCount == 0)
			System.out.println("No pending Gym Requests");
		else
			System.out.println("Successfully approved all pending gym requests!");
	}
}