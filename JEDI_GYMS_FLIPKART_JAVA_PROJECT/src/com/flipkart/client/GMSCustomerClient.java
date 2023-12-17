package com.flipkart.client;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.BookedSlot;
import com.flipkart.bean.Customer;
import com.flipkart.bean.Slot;
import com.flipkart.business.CustomerBusiness;
import com.flipkart.business.UserBusiness;
import com.flipkart.client.*;
import com.flipkart.exception.SlotNotFoundException;
import com.flipkart.exception.UserAlreadyExistsException;

public class GMSCustomerClient {
	Customer customer = new Customer();	
	static CustomerBusiness customerBusiness = new CustomerBusiness();
	static Scanner sc=new Scanner(System.in);
	
	public static void registerCustomer() {
		Customer customer = new Customer();	
		System.out.print("Enter email: ");
		customer.setEmailId(sc.next());
		System.out.print("Enter password: ");
		customer.setPassword(sc.next());
		System.out.print("Enter Name: ");
		customer.setName(sc.next());
		System.out.print("Enter Phone Number: ");
		customer.setPhoneNo(sc.next());
		System.out.print("Enter Age: ");
		customer.setAge(Integer.valueOf(sc.next()));
		System.out.print("Enter Address: ");
		customer.setAddress(sc.next());
		
		UserBusiness userBusiness = new UserBusiness();
		try {
			userBusiness.registerCustomer(customer);
			System.out
			.println("\nCustomer registered successfully!");
		} catch (UserAlreadyExistsException e) {
			System.out.println(e.getMessage());
			System.out.println("\nCustomer registration failed! Try again!");

		}	
	}
	
	public static void bookSlot() throws ParseException {
		//change to customer client
//		GMSAdminClient gdc = new GMSAdminClient();
		CustomerBusiness.getGyms();
		System.out.println("Enter user email id:");
		String user_email = sc.next();
		System.out.print("Enter gym ID: ");
		String gymId = sc.next();
		System.out.print("\nEnter Date (yyyy-mm-dd): ");
		String date = sc.next();
		try {
		List<Slot> slots = customerBusiness.getSlotInGym(gymId);
		
		System.out.printf("%15s%15s%15s", "Slot Id", "Start Time", "Availability");
		System.out.println();
		slots.forEach(slot -> {
			System.out.printf("%15s%15s%15s", slot.getId(), slot.getTime(), customerBusiness.isSlotBooked(slot.getId(), date)? "WaitingList": "Available");
		    System.out.println();
		});
		System.out.println("\n__________________________________________________________________________________\n");
		System.out.print("Enter the slot ID which you want to book: ");
		String slotId = sc.next();
		int bookingResponse = customerBusiness.bookSlot(gymId ,slotId , user_email, date);
		switch (bookingResponse) {
		case 0:
			System.out.println("\nYou have already booked this time. \nCancelling the previous one and booking this slot");
			break;
		case 1:
			System.out.println("\nSlot is already booked, added to the waiting list");
			break;
		case 2:
			System.out.println("\nSuccessfully booked the slot");
			break;
		default:
			System.out.println("\nBooking failed");
		}
		} catch (SlotNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void viewCatalog() {
		
	}
	
	public static void viewAllBookedSlots() {
		System.out.print("Enter customer email");
		String email = sc.next();
		List<BookedSlot> bookings = customerBusiness.getBookings(email);
		if (bookings.size() == 0) {
			System.out.println("No bookings found!" );
			return;
		}
		System.out.printf("%15s%15s%15s%15s", "Booking Id", "Slot Id", "Gym Id", "Date");
		System.out.println();
		bookings.forEach(booking -> {
			System.out.printf("%15s%15s%15s%15s", booking.getId(), booking.getSlotId(), booking.getGymCenterId(), booking.getDate());
			System.out.println();
		});
	}
	
	public static void cancelBookedSlot() {
		System.out.println("Enter the customer email id : ");
		String email = sc.next();
		System.out.print("\nEnter booking ID that you want to cancel: ");
		String bookingId = sc.next();
		customerBusiness.cancelBooking(bookingId, email);
	}
	
	public static void menu() throws ParseException, UserAlreadyExistsException {
	
		CustomerBusiness customerBusiness = new CustomerBusiness();

		while(true) {
			System.out.println( "------------------------------ \n1. Book slot \n 2. Cancel Booked slot \n 3. View all booked Slots \n 4. Exit \n ------------------------------ \n Enter your choice: " );

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				bookSlot();
				break;
			case 2:
				cancelBookedSlot();
				break;
			case 3:
				viewAllBookedSlots();
				break;
			case 4:
				GMSApplicationClient.menu();
				break;
			default:
				System.out.println( "Incorrect Choice");
			}
			break;
		}
	}

}
