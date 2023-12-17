package com.flipkart.DAO;

import java.util.List;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;

public interface AdminDAO {
	
	public List<GymOwner> getAllGymOwners();

	
	public List<GymCentre> getAllGyms();

	
	public List<GymOwner> getPendingGymOwnerRequests();

	
	public List<GymCentre> getPendingGymRequests();

	
	public int approveSingleOwnerRequest(String gymOwnerEmail);

	
	public int approveSingleGymRequest(String gymId);

}