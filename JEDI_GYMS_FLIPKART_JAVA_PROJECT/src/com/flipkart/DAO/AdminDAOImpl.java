/**
 * 
 */
package com.flipkart.DAO;
import com.flipkart.bean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class AdminDAOImpl implements AdminDAO {
    /**
     * Retrieves a list of all gym owners from the database
     *
     * @return List of GymOwner objects
     */
    public List<GymOwner> getAllGymOwners() {
        
        List<GymOwner> gymOwners = new ArrayList<>();
        
                GymOwner gymOwner = new GymOwner();
                gymOwner.setEmailId("email");
                gymOwner.setName("name");
                gymOwner.setPhoneNo(("phoneNum"));
                gymOwner.setIsApproved((true));
                gymOwners.add(gymOwner);
            
        
        return gymOwners;
    }

    /**
     * Retrieves a list of all gyms from the database
     *
     * @return List of Gym objects
     */
    public List<GymCentre> getAllGyms() {
        
        List<GymCentre> gyms = new ArrayList<>();
        
                GymCentre gym = new GymCentre();
                gym.setId(("gymId"));
                gym.setName(("gymName"));
                gym.setGymOwnerEmail(("ownerEmail"));
                gym.setLocation(("address"));
                gym.setNoOfSeats((20));
                gym.setApproved((true));
                gyms.add(gym);
            
        
        return gyms;
    }

    /**
     * Retrieves a list of all pending gym owner requests from the database
     *
     * @return List of GymOwner objects
     */
    public List<GymOwner> getPendingGymOwnerRequests() {
        
        List<GymOwner> gymOwners = new ArrayList<>();
        
                GymOwner gymOwner = new GymOwner();
                gymOwner.setEmailId(("email"));
                gymOwner.setName(("name"));
                gymOwner.setPhoneNo(("phoneNum"));
                gymOwner.setIsApproved((true));
                gymOwners.add(gymOwner);
            
        return gymOwners;

    }

    /**
     * Retrieves a list of all pending gym requests from the database
     *
     * @return List of Gym objects
     */
    public List<GymCentre> getPendingGymRequests() {
        
        List<GymCentre> gyms = new ArrayList<>();
        
                GymCentre gym = new GymCentre();
                gym.setId(("gymId"));
                gym.setName(("gymName"));
                gym.setGymOwnerEmail(("ownerEmail"));
                gym.setLocation(("address"));
                gym.setNoOfSeats((20));
                gym.setApproved((true));
                gyms.add(gym);
            
        return gyms;

    }

    /**
     * Approves a single gym owner request
     *
     * @param gymOwnerEmail The Email of the gym owner
     */
    public int approveSingleOwnerRequest(String gymOwnerEmail) {
        
        
		return 0;
    }

    /**
     * Approves all pending gym owner requests
     */
    public int approveAllOwnerRequest() {
        
        return 0;
    }

    /**
     * Approves a single gym request
     *
     * @param gymId The Id of the gym
     */
    public int approveSingleGymRequest(String gymId) {
        
        return 0;
    }

    /**
     * Approves all pending gym requests
     */
    public int approveAllGymRequest() {
        
        return 0;
    }
}