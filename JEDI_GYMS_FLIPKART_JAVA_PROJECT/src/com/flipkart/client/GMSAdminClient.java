package com.flipkart.client;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.*;

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
//				GMSApplicationClient.menu();
				break;

			default:
				System.out.println("Wrong Choice" );
			}
			break;
		}
	}
	public void viewAllGymOwners() {

		List<GymOwner> gymOwners = adminBusiness.getGymOwners();

		System.out.printf("GymOwner Email", "GymOwner Name", "Phone Number", "Aadhaar",
				"PAN number", "Verification");
		gymOwners.forEach(gymOwner -> {
		    System.out.println();
//		    System.out.printf(gymOwner.getEmail(), gymOwner.getName(),
//		            gymOwner.getPhoneNumber(), gymOwner.getAadharNumber(), gymOwner.getPanNumber(),
//		            gymOwner.isVerified() ? "Verified" : "Not Verified");
		});

	}
	public void viewAllGymCenters() {
		List<GymCentre> gyms = adminBusiness.getGym();
		
		System.out.println();
		System.out.printf("Gym Id", "Gym Name", "Gym Owner", "Address", "SlotCount",
				"SeatsPerSlot", "Verification");
		gyms.forEach(gym -> {
		    System.out.println();
//		    System.out.printf(gym.getGymId(), gym.getGymName(), gym.getOwnerEmail(),
//		            gym.getAddress(), gym.getSlotCount(), gym.getSeatsPerSlotCount(),
//		            gym.isVerified() ? "Verified" : "Not Verified");
		});
		System.out.println();

	}
	
	public void viewAllPendingGymOwnerRequests() {
		List<GymOwner> gymOwners = adminBusiness.viewAllPendingGymOwnerRequests();
		if (gymOwners.size() == 0) {
			System.out.println("No pending Gym Owner requests!");
			return;
		}

		System.out.printf("GymOwner Email", "GymOwner Name", "Phone Number", "Aadhaar",
				"PAN number", "Verification");
		gymOwners.forEach(gymOwner -> {
		    System.out.println();
//		    System.out.printf(gymOwner.getEmail(), gymOwner.getName(),
//		            gymOwner.getPhoneNumber(), gymOwner.getAadharNumber(), gymOwner.getPanNumber(),
//		            gymOwner.isVerified() ? "Verified" : "Not Verified");
		});
	}
	
	public void viewAllPendingGymRequests() {

		List<GymCentre> gyms = adminBusiness.viewAllPendingGymRequests();
		if (gyms.size() == 0) {
			System.out.println("No pending Gym requests!");
			return;
		}

		System.out.printf("Gym Id", "Gym Name", "Gym Owner", "Address", "SlotCount",
				"SeatsPerSlot", "Verification");
		gyms.forEach(gym -> {
		    System.out.println();
//		    System.out.printf(gym.getGymId(), gym.getGymName(), gym.getOwnerEmail(),
//		            gym.getAddress(), gym.getSlotCount(), gym.getSeatsPerSlotCount(),
//		            gym.isVerified() ? "Verified" : "Not Verified");
		});
		System.out.println();
	}
	

	public void approveGymRequest() {
		System.out.print("Enter gym Id: ");
	    adminBusiness.approveSingleGymRequest(sc.next()); 
	}
	
	public void approveGymOwnerRequest() {
		System.out.print("Enter gym owner email: ");
		adminBusiness.approveSingleGymOwnerRequest(sc.next());
		
	}

}