package com.flipkart.client;
import com.flipkart.bean.*;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.flipkart.business.*;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;
import com.flipkart.exception.UnauthorizedAccessException;
import com.flipkart.exception.UserAlreadyExistsException;
import com.flipkart.utils.IdGenerator;

public class GMSGymOwnerClient {
	User user = new User();
	static GymOwner gymOwner = new GymOwner();
	static GymOwnerBusiness gymOwnerBusiness = new GymOwnerBusiness();
	public static void registerGymOwner(Scanner in) throws UserAlreadyExistsException{
		UserBusiness userBusiness = new UserBusiness();
		
		GymOwner gymOwner = new GymOwner();
		System.out.println("Enter your email: ");
		gymOwner.setEmailId(in.next());
	
		System.out.println("Enter your name: ");
		gymOwner.setName(in.next());
		
		System.out.println("Enter your mobile: ");
		gymOwner.setPhoneNo(in.next());
		
		System.out.println("Enter your address: ");
		gymOwner.setAddress(in.next());
		
		System.out.println("Enter your GST number: ");
		gymOwner.setGstNo(in.next());
		
		System.out.println("Enter your password: ");
		String password = in.next();
		gymOwner.setIsApproved(false);
		userBusiness.registerGymOwner(gymOwner);
	
	}
	
	public static void getAllGymDetails(Scanner in, String email) {
		List<GymCentre> gymDetails = gymOwnerBusiness.getGymDetail(email);
		if (gymDetails.size() == 0) {
			System.out.println("Sorry, no gyms found!");
			return;
		}
		System.out.printf("%15s%15s%15s%15s%15s", "Gym Id", "Gym Name", "Address", "SeatsPerSlot", "Verification");
		gymDetails.forEach(gym -> {
		    System.out.println();
		    System.out.printf("%15s%15s%15s%15s%15s", gym.getId(), gym.getName(), gym.getLocation(),
		            gym.getNoOfSeats(),
		            gym.isApproved() ? "Verified" : "Not Verified");
		});
		System.out.println();
	}
	
	public static void addSlots(Scanner in, String email) {
		Slot slot = new Slot();
		System.out.println("Enter Slot Details: ");
		slot.setId(IdGenerator.generateId("Slot"));
		System.out.println("Enter Gym Id:");
		slot.setGymId(IdGenerator.generateId(""));
		in.next();
		System.out.println("Enter Slot Date: ");
		slot.setDate(in.next());
		System.out.println("Enter Slot Time: ");
		slot.setTime(IdGenerator.generateId("Slot"));
		in.next();
		System.out.println("Enter number of seats in slot: ");
		try {
			slot.setNumOfSeats(in.nextInt());
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.print("Enter Trainer: ");
		slot.setTrainer(in.next());
		slot.setNumOfSeatsBooked(0);
		
		try {
			gymOwnerBusiness.addSlot(slot, email);
		} catch (GymNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (UnauthorizedAccessException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void getGymOwnerDetails(Scanner in, String email) {
		try {
			gymOwner = gymOwnerBusiness.getProfile(email);
		} catch (GymOwnerNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("______________________________________________________________");
		System.out.printf("%15s%15s%15s%15s", "Gym Owner Name", "Phone Number", "PAN Number", "Aadhaar Number");
		System.out.println();
		System.out.printf("%15s%15s%15s%15s", gymOwner.getName(), gymOwner.getPhoneNo());
		System.out.println("\n______________________________________________________________");
	}

	public static void menu(Scanner in, String email) throws UserAlreadyExistsException, ParseException {
				
		while(true) {
			System.out.println("------------------------------ \n 1. Add Gyms \n 2. View All Gyms \n 3. Add Slots in a Gym \n 4. View All Slots of a Gym \n 5. View Own Details \n 6. Exit \n ------------------------------ \n Enter your choice: " );
			

			int choice = in.nextInt();
			switch (choice) {
			case 1:
				registerGymOwner(in);
				break;
			case 2:
				getAllGymDetails(in, email);
				break;
			case 3:
				addSlots(in, email);
				break;
			case 4:
//				viewAllSlots();
				break;
			case 5:
				getGymOwnerDetails(in, email);
				break;
			case 6:
				GMSApplicationClient.menu();
				break;
			default:
				System.out.println("Incorrect Choice");
			}
			break;
		}
	}

}
