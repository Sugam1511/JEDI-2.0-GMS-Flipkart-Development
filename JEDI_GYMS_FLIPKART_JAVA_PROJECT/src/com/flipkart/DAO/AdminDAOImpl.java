package com.flipkart.DAO;
import com.flipkart.bean.*;
import java.util.ArrayList;
import java.util.List;


public class AdminDAOImpl implements AdminDAO {
    
    public List<GymOwner> getAllGymOwners() {
    	List<GymOwner> gymOwners = new ArrayList<>();

      
        gymOwners.add(new GymOwner());
        gymOwners.get(0).setEmailId("abc@gmail.com");
        gymOwners.get(0).setName("abc");
        gymOwners.get(0).setPhoneNo("9900990099");
        gymOwners.get(0).setIsApproved((true));
//        gymOwners.get(0).add(gymOwner);


return gymOwners;
        
    }

    
    public List<GymCentre> getAllGyms() {
    	 List<GymCentre> gyms = new ArrayList<>();

         GymCentre gym = new GymCentre();
         gym.setId(101);
         gym.setName("GYM 1");
         gym.setGymOwnerEmail(("abc@gmail.com"));
         gym.setLocation(("Patna"));
         gym.setNoOfSeats((20));
         gym.setApproved((true));
         gyms.add(gym);


 return gyms;
        
    }

    
    public List<GymOwner> getPendingGymOwnerRequests() {
    	List<GymOwner> gymOwners = new ArrayList<>();

        GymOwner gymOwner = new GymOwner();
        gymOwner.setEmailId(("a1@gmail.com"));
        gymOwner.setName(("a1"));
        gymOwner.setPhoneNo(("249023"));
        gymOwner.setIsApproved((false));
        gymOwners.add(gymOwner);

return gymOwners;
        
    }

    
    public List<GymCentre> getPendingGymRequests() {
    	List<GymCentre> gyms = new ArrayList<>();

        GymCentre gym = new GymCentre();
        gym.setId(101);
        gym.setName(("GYM 2"));
        gym.setGymOwnerEmail(("b1@gmail.com"));
        gym.setLocation(("Bangalore"));
        gym.setNoOfSeats((20));
        gym.setApproved((false));
        gyms.add(gym);

return gyms;
        

    }

   
    public int approveSingleOwnerRequest(String gymOwnerEmail) {
    	List<GymOwner> gymOwners = getAllGymOwners() ;
    	gymOwners.forEach(
    			(temp) -> {
    				if(temp.getEmailId() == gymOwnerEmail) {
    					temp.setIsApproved(true);
    				}
    			}
    			);
		return 0;
        
    }

    
    public int approveAllOwnerRequest() {
    	List<GymOwner> gymOwners = getAllGymOwners() ;
    	gymOwners.forEach(
    			(temp) -> {
    					temp.setIsApproved(true);
    			}
    			);
		return 0;
        
    }

    
    public int approveSingleGymRequest(int gymId) {
    	List<GymCentre> gyms = getAllGyms();
    	gyms.get(gymId).setApproved(true);
		return 0;
        
    }

   
    public int approveAllGymRequest() {
    	List<GymCentre> gyms = getAllGyms();
    	gyms.forEach(
    			(temp) -> {temp.setApproved(true);}
    			);
		return 0;
        
    }


	@Override
	public int approveSingleGymRequest(String gymId) {
		// TODO Auto-generated method stub
		return 0;
	}


}