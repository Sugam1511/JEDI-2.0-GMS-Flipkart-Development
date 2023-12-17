/**
 *
 */
package com.flipkart.business;

import com.flipkart.DAO.*;
import com.flipkart.bean.*;
import com.flipkart.exception.CustomerNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;
import com.flipkart.exception.SlotNotFoundException;
import com.flipkart.utils.IdGenerator;
import java.util.Date;
import java.util.*;

public class CustomerBusiness implements CustomerBusinessInterface {

	static CustomerDAOImpl customerDAO = new CustomerDAOImpl();
//	List<Customer> customers = new ArrayList<>();
//	List<Booking> bookings = new ArrayList<>();
//
//	List<Slot> slots = new ArrayList<>();
//	List<Gym> gyms = new ArrayList<>();
	//Date d1 = new Date();
	

	public Customer getProfile(Customer customer) throws CustomerNotFoundException {
		System.out.println("Successfully fetched the customer profile");
			Customer cus=	customerDAO.getProfile(customer);
		if (cus == null)
			throw new CustomerNotFoundException();
		System.out.println("Fetched Customer details successfully! ");
		return cus;
	}

	public void editProfile(Customer customer) throws CustomerNotFoundException{
		int updatedCount = customerDAO.editCustomerDetails(customer);
		if (updatedCount == 0)
			throw new CustomerNotFoundException();
		//System.out.println(ColorConstants.GREEN + "\nEdited your profile Successfully!" + ColorConstants.RESET);
	}
	
	public List<BookedSlot> getBookings(String email) {
		System.out.println("Successfully fetched the list of bookings");
	      return customerDAO.fetchBookedSlots(email);
	}
	
	public boolean cancelBooking(String bookingId, String email)  {
		System.out.println("Successfully cancelled the booking ");
		return customerDAO.cancelBooking(bookingId, email);
	}
	
	
	public static List<GymCentre> getGyms() {
		System.out.println("\nSuccessfully fetched the gyms :\n");
		return customerDAO.fetchGymList();
		
	}
	
	public List<Slot> getSlotInGym(String gymId) throws SlotNotFoundException{
		
			List<Slot> slotsOfGym = customerDAO.fetchSlotList(gymId);
			if(slotsOfGym.size() == 0) throw new SlotNotFoundException();
			return slotsOfGym;
		
	}
	
	public int bookSlot(String gymId, String slotId, String email, String date)
	{
		Integer bookedSeatsNum = customerDAO.getNumberOfSeatsBooked(slotId);
		Integer totalSeatsNum = customerDAO.getNumberOfSeats(slotId);
		if(customerDAO.alreadyBooked(slotId, email, date))
		{
			//System.out.println("entered already booked");
			customerDAO.cancelBooking(slotId, email);
			customerDAO.updateNumOfSeats(slotId,bookedSeatsNum--);
			if(bookedSeatsNum<totalSeatsNum)
			{
				customerDAO.updateNumOfSeats(slotId,bookedSeatsNum++);
				customerDAO.bookSlots(IdGenerator.generateId("Booking"), slotId, gymId,"confirmed",date,email);
			}
			else
			{
				customerDAO.updateNumOfSeats(slotId,bookedSeatsNum++);
				customerDAO.bookSlots(IdGenerator.generateId("Booking"), slotId, gymId,"waitlisted",date,email);
			}
			return 0;
		}
		if(customerDAO.isFull(slotId, date))
		{
			customerDAO.updateNumOfSeats(slotId,bookedSeatsNum++);
			customerDAO.bookSlots(IdGenerator.generateId("Booking"), slotId, gymId,"waitlisted",date,email);
			return 1;
		}
		else
		{
			if(bookedSeatsNum<totalSeatsNum)
			{
				customerDAO.updateNumOfSeats(slotId,bookedSeatsNum++);
				customerDAO.bookSlots(IdGenerator.generateId("Booking"), slotId, gymId,"confirmed",date,email);
			}
			else
			{
				customerDAO.updateNumOfSeats(slotId,bookedSeatsNum++);
				customerDAO.bookSlots(IdGenerator.generateId("Booking"), slotId, gymId,"waitlisted",date,email);
			}
			return 2;
		}
		
	}
	

	public boolean isSlotBooked(String slotId, String date) {
		return customerDAO.isFull(slotId, date);
	}

	public boolean hasBookedSlotAlready(String slotId, String customerEmail, String date) {
		return customerDAO.alreadyBooked(slotId, customerEmail, date);
	}
	
	/**
	 * Checks if a gym is approved for a specified gym ID.
	 * @param gymId The ID of the gym
	 * @return true if the gym is approved, false otherwise
	 */
	public boolean checkGymApprove(String gymId) {
		return customerDAO.checkGymApprove(gymId);
	}

}