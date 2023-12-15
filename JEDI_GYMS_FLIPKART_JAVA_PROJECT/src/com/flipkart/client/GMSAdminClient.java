package com.flipkart.client;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.*;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;

public class GMSAdminClient {
	AdminBusiness adminBusiness = new AdminBusiness();
	Scanner sc=new Scanner(System.in);
	public void menu() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Admin Menu");
			System.out.println("1. View All Gym Owners \n 2. View All Gyms \n 3. View Pending Gym Owner Requests \n 4. View Pending Gym Requests \n 5. Approve Gym Request \n 6. Approve Gym Owner Request \n 7. Exit \n ------------------------------ \n Enter your choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				viewAllGymOwners();
				break;
			case 2:
				viewAllGymCenters();
				break;
			case 3:
				viewAllPendingGymOwnerRequests();
				break;
			case 4:
				viewAllPendingGymRequests();
				break;
			case 5:
				approveGymRequest();
				break;
			case 6:
				approveGymOwnerRequest();
				break;
			case 7:
				GMSApplicationClient.menu();
				break;

			default:
				System.out.println("Wrong Choice" );
			}
			break;
		}
	}
	public void viewAllGymOwners() {

		List<GymOwner> gymOwners = adminBusiness.getGymOwners();

		System.out.printf("GymOwner Email", "GymOwner Name", "Phone Number", "Verification");
		gymOwners.forEach(gymOwner -> {
		    System.out.println();
		    System.out.printf(gymOwner.getEmailId(), gymOwner.getName(),
		            gymOwner.getPhoneNo(),
		            gymOwner.getIsApproved() ? "Verified" : "Not Verified");
		});

	}
	public void viewAllGymCenters() {
		List<GymCentre> gyms = adminBusiness.getGym();
		
		System.out.println();
		System.out.printf("Gym Id", "Gym Name", "Gym Owner", "Address",
				"SeatsPerSlot", "Verification");
		gyms.forEach(gym -> {
		    System.out.println();
		    System.out.printf(gym.getId(), gym.getName(), gym.getGymOwnerEmail(),
		            gym.getLocation(), gym.getNoOfSeats(),
		            gym.isApproved() ? "Verified" : "Not Verified");
		});
		System.out.println();

	}
	
	public void viewAllPendingGymOwnerRequests() {
		List<GymOwner> gymOwners = adminBusiness.viewAllPendingGymOwnerRequests();
		if (gymOwners.size() == 0) {
			System.out.println("No pending Gym Owner requests!");
			return;
		}

		System.out.printf("GymOwner Email", "GymOwner Name", "Phone Number", "Verification");
		gymOwners.forEach(gymOwner -> {
		    System.out.println();
		    System.out.printf(gymOwner.getEmailId(), gymOwner.getName(),
		            gymOwner.getPhoneNo(),
		            gymOwner.getIsApproved() ? "Verified" : "Not Verified");
		});
	}
	
	public void viewAllPendingGymRequests() {

		List<GymCentre> gyms = adminBusiness.viewAllPendingGymRequests();
		if (gyms.size() == 0) {
			System.out.println("No pending Gym requests!");
			return;
		}

		System.out.printf("Gym Id", "Gym Name", "Gym Owner", "Address",
				"SeatsPerSlot", "Verification");
		gyms.forEach(gym -> {
		    System.out.println();
		    System.out.printf(gym.getId(), gym.getName(), gym.getGymOwnerEmail(),
		            gym.getLocation(), gym.getNoOfSeats(),
		            gym.isApproved() ? "Verified" : "Not Verified");
		});
		System.out.println();
	}
	

	public void approveGymRequest() {
		
		adminBusiness.approveSingleGymRequest(sc.next());
		
	}
	
	public void approveGymOwnerRequest() {
		System.out.print("Enter gym owner email: ");
		try {
			adminBusiness.approveSingleGymOwnerRequest(sc.next());
		} catch (GymOwnerNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}