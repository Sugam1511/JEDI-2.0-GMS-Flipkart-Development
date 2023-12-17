package com.flipkart.client;
import com.flipkart.bean.*;

import java.text.ParseException;
import java.util.Scanner;
import com.flipkart.client.*;
import com.flipkart.exception.UserAlreadyExistsException;
public class GMSApplicationClient {

	public static void menu() throws UserAlreadyExistsException, ParseException {
		System.out.println("Welcome to FlipFit Application \n ------------------------------ \n Menu: \n 1. Login \n 2. Customer Registration \n 3. GymOwner Registration \n 4. exit \n ------------------------------" );
		Scanner sc = new Scanner(System.in);

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
					GMSGymOwnerClient Owner = new GMSGymOwnerClient();
//					Owner.registerGymOwner(sc); 
					
					break;
				case 4:
					break;
				default:
					System.out.println( "Wrong Choice");
			}
			break;
		}
	}
	public static void main(String[] args) throws UserAlreadyExistsException, ParseException {
		// TODO Auto-generated method stub
//		GMSApplicationClient gac = new GMSApplicationClient();
		menu();


	}

}