package com.flipkart.DAO;
import com.flipkart.bean.*;
import java.util.ArrayList;
import java.util.List;


public class AdminDAOImpl implements AdminDAO {
    
    public List<GymOwner> getAllGymOwners() {
		return null;
        
    }

    
    public List<GymCentre> getAllGyms() {
		return null;
        
    }

    
    public List<GymOwner> getPendingGymOwnerRequests() {
		return null;
        
    }

    
    public List<GymCentre> getPendingGymRequests() {
		return null;
        

    }

   
    public int approveSingleOwnerRequest(String gymOwnerEmail) {
		return 0;
        
    }

    
    public int approveAllOwnerRequest() {
		return 0;
        
    }

    
    public int approveSingleGymRequest(String gymId) {
		return 0;
        
    }

   
    public int approveAllGymRequest() {
		return 0;
        
    }

}