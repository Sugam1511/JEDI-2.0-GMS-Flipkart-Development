package com.flipkart.client;

import java.util.Scanner;

public class GMSCustomerClient {
	public static void menu() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println( "------------------------------ \n 1. Book slot \n 2. Cancel Booked slot \n 3. View all booked Slots \n 4. View catalog \n 5. Exit \n ------------------------------ \n Enter your choice: " );

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
//				bookSlot();
				break;
			case 2:
//				cancelBookedSlot();
				break;
			case 3:
//				viewAllBookedSlots();
				break;
			case 4:
//				viewCatalog();
				break;
			case 5:
//				GMSApplicationClient.menu();
				break;
			default:
				System.out.println( "Incorrect Choice");
			}
			break;
		}
	}

}
