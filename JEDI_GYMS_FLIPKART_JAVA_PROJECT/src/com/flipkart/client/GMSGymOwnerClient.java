package com.flipkart.client;

import java.util.Scanner;

public class GMSGymOwnerClient {
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("------------------------------ \n 1. Add Gyms \n 2. View All Gyms \n 3. Add Slots in a Gym \n 4. View All Slots of a Gym \n 5. View Own Details \n 6. Exit \n ------------------------------ \n Enter your choice: " );
			

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
//				registerGym();
				break;
			case 2:
//				getAllGymDetails();
				break;
			case 3:
//				addSlots();
				break;
			case 4:
//				viewAllSlots();
				break;
			case 5:
//				getGymOwnerDetails();
				break;
			case 6:
//				GMSApplicationClient.menu();
				break;
			default:
				System.out.println("Incorrect Choice");
			}
			break;
		}
	}

}
