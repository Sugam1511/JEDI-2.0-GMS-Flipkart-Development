package com.flipkart.business;
import com.flipkart.bean.*;
import java.util.ArrayList;
import java.util.List;
import com.flipkart.DAO.*;
public class UserBusiness {
	UserDaoImpl userDaoImpl = new UserDaoImpl();
	public void registerGymOwner(GymOwner gymOwner) {
		
		userDaoImpl.registerGymOwner(gymOwner);
		System.out.println( "GymOwner registered");
//		System.out.println("GymOwner registered"); //Make this Green
	}
	

}
