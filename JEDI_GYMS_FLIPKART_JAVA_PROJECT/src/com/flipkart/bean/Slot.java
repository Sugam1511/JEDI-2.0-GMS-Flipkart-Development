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
	private int gymId;
	private String time;
	private String date;
	private Queue<Integer> waitingList;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	public int getGymId() {
		return gymId;
	}

	public void setGymId(int gymId) {
		this.gymId = gymId;
	}

	public Slot() {
		waitingList = new LinkedList<>();
	}

	public String getId() {
		return id;
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
	
	
}