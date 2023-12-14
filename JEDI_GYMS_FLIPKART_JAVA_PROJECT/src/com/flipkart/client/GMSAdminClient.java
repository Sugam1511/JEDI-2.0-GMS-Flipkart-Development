package com.flipkart.client;

import java.util.Scanner;

public class GMSAdminClient {
	public static void menu() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Admin Menu");
			System.out.println("1. View All Gym Owners \n 2. View All Gyms \n 3. View Pending Gym Owner Requests \n 4. View Pending Gym Requests \n 5. Approve Gym Request \n 6. Approve Gym Owner Request \n 7. Exit \n ------------------------------ \n Enter your choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
//				viewAllGymOwners();
				break;
			case 2:
//				viewAllGymCenters();
				break;
			case 3:
//				viewPendingGymOwnerRequests();
				break;
			case 4:
//				viewPendingGymRequests();
				break;
			case 5:
//				approveGymRequest();
				break;
			case 6:
//				approveGymOwnerRequest();
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

}
