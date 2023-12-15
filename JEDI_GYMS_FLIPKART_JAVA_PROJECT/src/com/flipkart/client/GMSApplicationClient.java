package com.flipkart.client;

import java.util.Scanner;

public class GMSApplicationClient {
	static void menu() {
		Scanner sc=new Scanner(System.in);
	while(true) {
		int choice = sc.nextInt();

		switch (choice) {
			case 1:
				System.out.println("Enter username");
				String username = sc.next();
				System.out.println("Enter password");
				String password = sc.next();
				System.out.println("Enter role");
				String role = sc.next();
				
				if(role.equalsIgnoreCase("Admin")) {
					GMSAdminClient gmsAdminClient = new GMSAdminClient();
					gmsAdminClient.menu();
					break;
				} else if (role.equalsIgnoreCase("GymOwner")) {
					GMSGymOwnerClient.menu();
					break;
				} else if (role.equalsIgnoreCase("Customer")){
					GMSCustomerClient.menu();
					break;
				} else {
					System.out.println("Invalid role");
				}
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				break;
			default:
				System.out.println( "Wrong Choice");
		}
		break;
	}
	

}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to FlipFit Application \n ------------------------------ \n Menu: \n 1. Login \n 2. Customer Registration \n 3. GymOwner Registration \n 4. exit \n ------------------------------");
		menu();

}
	
}