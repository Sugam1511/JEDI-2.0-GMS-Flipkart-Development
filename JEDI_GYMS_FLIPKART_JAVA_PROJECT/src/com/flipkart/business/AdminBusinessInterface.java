package com.flipkart.business;

import com.flipkart.bean.*;

import java.util.*;

public interface AdminBusinessInterface{
	 /*
    returns the list of all the gym owners
    */
    public List<GymOwner> getGymOwners();
   
    /*
    returns the list of all the gyms
    */
    public List<GymCentre> getGym() ;
    
    /*
    returns the list of all the gym owners whose requests are pending
    */
    public List<GymOwner> viewAllPendingGymOwnerRequests();
    
    /*
    approves the gym owner request whose email is passed
    */
    public void approveSingleGymOwnerRequest(String gymOwnerEmail);
   
    /*
    approves all the pending gym owner requests
    */
    public void approveAllPendingGymOwnerRequests();
    
    /*
    returns the list of all the gyms whose request is pending
   */
    public List<GymCentre> viewAllPendingGymRequests();
    
    /*
    approves single gym whose gymId is sent
    */
    public void approveSingleGymRequest(String gymId);
   
    /*
    approves all the pending gym requests
    */
    public void approveAllPendingGymRequests();
    
}