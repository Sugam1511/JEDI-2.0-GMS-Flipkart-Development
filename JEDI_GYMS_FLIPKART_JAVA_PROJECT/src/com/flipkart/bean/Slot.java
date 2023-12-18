/**
 * 
 */
package com.flipkart.bean;
import java.util.Queue;
import java.util.LinkedList;


/**
 * 
 */
public class Slot {
	
	private String id;
	private String gymId;
	private String time;
	private String date;
	private int numOfSeats;
	private String trainer;
	private int numOfSeatsBooked;
	private Queue<Integer> waitingList;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	public String getGymId() {
		return gymId;
	}

	public void setGymId(String gymId) {
		this.gymId = gymId;
	}

	public Slot() {
		waitingList = new LinkedList<>();
	}

	public String getId() {
		return id;
	}
	
	public int getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}	
	
	public void setNumOfSeatsBooked(int numOfSeatsBooked)
	{
		this.numOfSeatsBooked=numOfSeatsBooked;
	}
	
	public int getNumOfSeatsBooked()
	{
		return numOfSeatsBooked;
	}
	
	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	
	
}