/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.DAO.*;
import com.flipkart.exception.GymNotFoundException;
import com.flipkart.exception.GymOwnerNotFoundException;
import com.flipkart.exception.UnauthorizedAccessException;

import java.util.*;

/**
 * 
 */
public class GymOwnerBusiness implements GymOwnerBusinessInterface {
	GymOwnerDAOImpl gymOwnerDAO = new GymOwnerDAOImpl();

	/**
	 * Obtains gym owner's profile details 
	 * @param email the email of the gym owner whose profile details are requested
	 * @return GymOwner the gym owner object
	 * @throws GymOwnerNotFoundException 
	 */
	public GymOwner getProfile(String email) throws GymOwnerNotFoundException {
		GymOwner gymOwner = gymOwnerDAO.getGymOwnerDetails(email);
		if (gymOwner == null)
			throw new GymOwnerNotFoundException();
		System.out.println("Fetched Gym owner details successfully! " + email);
		return gymOwner;
	}
	/**
	 * Gives functionality of updating gym onwer's personal data. 
	 * @param gymOwnerNew the gymOwner object in which the profile data needs to be updated
	 * @param email the gymOwner email for which the profile data needs to be update
	 * @throws GymOwnerNotFoundException 
	 */
	public void editProfile(GymOwner gymOwnerNew) throws GymOwnerNotFoundException {
		int updatedCount = gymOwnerDAO.editGymOwnerDetails(gymOwnerNew);
		if (updatedCount == 0)
			throw new GymOwnerNotFoundException();
		System.out.println("\nEdited your profile Successfully!");
	}
	/**
	 * This method allows a gym owner to add details of a particular gym.
	 * @param gym the gym object representing the gym details
	 */
	public boolean addGym(GymCentre gym) {
		gymOwnerDAO.addGym(gym);
		System.out.println("\nAdded Gym Successfully! " + gym.getId());
		return true;
	}
	/**
	 * This method allows a gym owner to edit details of a particular gym.
	 * @param gym the gym object representing the gym details
	 * @throws GymNotFoundException 
	 */
//	public void editGym(GymCentre gym) throws GymNotFoundException {
//		int updatedCount = gymOwnerDAO.editGym(gym);
//		if (updatedCount == 0)
//			throw new GymNotFoundException();
//		System.out.println("\nEdited Gym Details Successfully! " + gym.getGymId());
//	}
	/**
	 * Obtains all the gyms that owned by the given gym owner.
	 * @param gymOwnerEmail the gym owner's email for which the list of gyms is requested
	 * @return list of gyms owned by the given gym owner
	 */
	public List<GymCentre> getGymDetail(String gymOwnerEmail) {
		System.out.println("\nFetched gym details successfully! \n");
		return gymOwnerDAO.getGymsOfGymOwner(gymOwnerEmail);
	}
	/**
	 * This method allows a gym owner to add details of a slot.
	 * @param slot the slot object representing the slot details
	 * @throws GymNotFoundException 
	 * @throws UnauthorizedAccessException 
	 */
	public void addSlot(Slot slot, String ownerEmail) throws GymNotFoundException, UnauthorizedAccessException {
		if (!(gymOwnerDAO.addSlot(slot, ownerEmail)))
			throw new GymNotFoundException();
		System.out.println("\nAdded slot successfully!");
	}
	/**
	 * Checks if the gym owner is verified or not.
	 * @param email the gym owner's email 
	 * @return true if the gym owner is verified else returns false;
	 */
	public boolean isApproved(String email) {
		return gymOwnerDAO.checkOwnerApproval(email);
	}
	/**
	 * Checks if the gym is verified or not.
	 * @param gymId the gym id for which the verification status is requested
	 * @return true if the gym is verified else returns false;
	 */
	public boolean isGymApproved(String gymId) {
		return gymOwnerDAO.checkGymApproval(gymId);
	}
}