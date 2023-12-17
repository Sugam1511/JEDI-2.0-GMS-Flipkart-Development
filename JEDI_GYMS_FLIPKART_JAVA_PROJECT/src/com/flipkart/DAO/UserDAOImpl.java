package com.flipkart.DAO;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;



import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{

	public boolean registerGymOwner(GymOwner gymOwner){
		boolean registerSuccess = false;
		List<GymOwner> gymOwners  = new ArrayList<>();
		gymOwner.setUserId(gymOwners.size());
        System.out.println("Registering new Gym Owner...");
        gymOwners.add(gymOwner);
        
        System.out.println("Gym Owner Registered Successfully");
        
		System.out.println("Gym owner Details are:\n");
		System.out.println("Gym Id : "+gymOwners.get(gymOwners.size()-1).getUserId());
		System.out.println("Name : "+gymOwners.get(gymOwners.size()-1).getName());
		System.out.println("Email : "+gymOwners.get(gymOwners.size()-1).getEmailId());
		System.out.println("Phone :"+gymOwners.get(gymOwners.size()-1).getPhoneNo());
		System.out.println("Address : "+gymOwners.get(gymOwners.size()-1).getAddress());
		System.out.println("GST Number : "+gymOwners.get(gymOwners.size()-1).getGstNo());
		
		return registerSuccess;
	}

	@Override
	public boolean authenticateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerCustomer(Customer customer) {
		boolean registerSuccess = true;
		// TODO Auto-generated method stub
		
		
		return true;
	}
}