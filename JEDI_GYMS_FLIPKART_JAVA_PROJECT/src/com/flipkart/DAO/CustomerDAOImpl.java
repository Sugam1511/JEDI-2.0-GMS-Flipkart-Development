package com.flipkart.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;

import com.flipkart.bean.*;
//import com.flipkart.constants.SQLConstants;
import com.flipkart.exception.*;
//import com.flipkart.utils.DBUtils;

public class CustomerDAOImpl implements CustomerDAO {

    // returns the list of all the gyms
	public List<GymCentre> fetchGymList() {
//        Connection connection = null;
        List<GymCentre> gyms = new ArrayList<GymCentre>();

     GymCentre gym = new GymCentre();
     gym.setId(101);
     gym.setName("GYM 1");
     gym.setGymOwnerEmail(("abc@gmail.com"));
     gym.setLocation(("Patna"));
     gym.setNoOfSeats((20));
     gym.setApproved((true));
     gyms.add(gym);


        return gyms;
    }
    

    // shows all the slots in the provided gym
    public List<Slot> fetchSlotList(String gymId) throws SlotNotFoundException {

    	   List<Slot> slots=new ArrayList<>();
    	   
    	   // slot 1
	         Slot s=new Slot();
	         s.setId("1012");
	         s.setGymId("101");
	         s.setTime("12:00");
	         s.setDate("2023-12-17");
	         slots.add(s);
    	   return slots;
    	}
    // shows all the bookings of the slots made by the customer
    public List<BookedSlot> fetchBookedSlots(String email) {
        List<BookedSlot> bookings=new ArrayList<>();

    	BookedSlot bs = new BookedSlot();
    	bs.setId(1011);
    	bs.setCustomerEmail("d1@gmail.com");
    	bs.setGymCenterId(101);
    	bs.setDate("2023-12-17");
    	bs.setSlotId(1012);
    	bs.setActive(true);
    	System.out.println("Slots has been booked. Your booking ID is : " + bs.getId());
    	bookings.add(bs);
        
        return bookings;
    }

    // books the slot with the given slotId for the customer
    public void bookSlots(String bookingId, String slotId, String gymId, String type, String date, String customerEmail) {

    	
    	BookedSlot bs = new BookedSlot();
    	bs.setId(1011);
    	bs.setCustomerEmail("d1@gmail.com");
    	bs.setGymCenterId(101);
    	bs.setDate("2023-12-17");
    	bs.setSlotId(1012);
    	bs.setActive(true);
    	System.out.println("Slots has been booked. Your booking ID is : " + bs.getId());
    }

    // returns true if the slot is fully booked
    public boolean isFull(String slotId, String date) {
//        Connection connection = null;
//        try {
//            connection = DBUtils.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_CHECK_FULL_SLOT);
//            preparedStatement.setString(1, slotId);
//            ResultSet rs = preparedStatement.executeQuery();
//            return rs.next();
//        } catch (SQLException e) {
////            printSQLException(e);
//        }
        return false;
    }

    // checks if the slot is already booked by the customer
    public boolean alreadyBooked(String slotId, String email, String date) {
//        Connection connection = null;
//        try {
//            connection = DBUtils.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_CHECK_ALREADY_BOOKED);
//            preparedStatement.setString(1, slotId);
//            preparedStatement.setString(2, email);
//            ResultSet rs = preparedStatement.executeQuery();
//            return rs.next();
//        } catch (SQLException e) {
////            printSQLException(e);
//        }
        return false;
    }

    public int getNumberOfSeatsBooked(String slotId)
    {
//    	Connection connection = null;
//    	
//    	try {
//            connection = DBUtils.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_GET_NUMBER_OF_BOOKED_SEATS);
//            preparedStatement.setString(1, slotId);
//            ResultSet rs =  preparedStatement.executeQuery();
//            while (rs.next()) {
//            	return rs.getInt("numOfSeatsBooked");
//            }
//            
//    	}
//    	catch (SQLException sqlExcep) {
////            printSQLException(sqlExcep);
//        }
//    	return 0;
//    }
//    public int getNumberOfSeats(String slotId)
//    {
//    	Connection connection = null;
//    	
//    	try {
//            connection = DBUtils.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_GET_NUMBER_OF_SEATS);
//            preparedStatement.setString(1, slotId);
//            ResultSet rs =  preparedStatement.executeQuery();
//            while (rs.next()) {
//            	return rs.getInt("numOfSeats");
//            }
//            
//    	}
//    	catch (SQLException sqlExcep) {
////            printSQLException(sqlExcep);
//        }
    	return 0;
    }
    
    public boolean updateNumOfSeats(String slotId, int seats)
    {
//    	Connection connection = null;
//    	try {
//            connection = DBUtils.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_UPDATE_NUMBER_OF_BOOKED_SEATS);
//            preparedStatement.setString(2, slotId);
//            preparedStatement.setInt(1, seats);
//            preparedStatement.executeUpdate(); 
//            return true;
//    	}
//    	catch (SQLException sqlExcep) {
////            printSQLException(sqlExcep);
//        }
    	return false;
    }
    
    // cancels the booking of the customer made earlier
    public boolean cancelBooking(String bookingId, String email) {
//        Connection connection = null;
//        try {
//            connection = DBUtils.getConnection();
//            PreparedStatement statement = connection.prepareStatement(SQLConstants.SQL_DELETE_BOOKING);
//            statement.setString(2, bookingId);
//            statement.setString(1, email);
//            statement.executeUpdate();
//            return true;
//        } catch (SQLException sqlExcep) {
////            printSQLException(sqlExcep);
//        }
        return true;
    }

    // checks if the slot exists or not
    public boolean checkSlotExists(String slotId, String gymId) {
//        Connection connection = null;
//        try {
//            connection = DBUtils.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_CHECK_SLOT_EXISTS);
//            preparedStatement.setString(1, slotId);
//            preparedStatement.setString(2, gymId);
//            System.out.println(preparedStatement);
//            ResultSet rs = preparedStatement.executeQuery();
//            return rs.next();
//        } catch (SQLException e) {
////            printSQLException(e);
//        }
        return true;
    }

    // checks if the gym is approved
    public boolean checkGymApprove(String gymId) {
//        Connection connection = null;
//        try {
//            connection = DBUtils.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_CHECK_GYM_APPROVAL);
//            preparedStatement.setString(1, gymId);
//            System.out.println(preparedStatement);
//            ResultSet rs = preparedStatement.executeQuery();
//            return rs.next();
//        } catch (SQLException e) {
////            printSQLException(e);
//        }
        return true;
    }
    public Customer getProfile(Customer customer)
    {
        return customer;
    }

    public int editCustomerDetails(Customer customer) {
//        Connection connection = null;
//        try {
//            connection = DBUtils.getConnection();
//
//            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_UPDATE_USER);
//            preparedStatement.setString(1, customer.getEmail());
//            preparedStatement.setString(2, customer.getPassword());
//            preparedStatement.setString(3, "customer");
//            preparedStatement.setString(4, customer.getEmail());
//            // Step 3: Execute the query or update query
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            // print SQL exception information
////            printSQLException(e);
//        }
//        try {
//            connection = DBUtils.getConnection();
//
//            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_UPDATE_CUSTOMER);
//            preparedStatement.setString(1, customer.getName());
//            preparedStatement.setString(2, customer.getPhoneNumber());
//            preparedStatement.setInt(3,customer.getAge());
//            preparedStatement.setString(4, customer.getAddress());
//            preparedStatement.setString(5, customer.getEmail());
//            // Step 3: Execute the query or update query
//          return  preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            // print SQL exception information
////            printSQLException(e);
//        }
//
//        System.out.println(SQLConstants.SQL_UPDATE_CUSTOMER);
//        // Step 1: Establishing a Connection
        return 0;
    }
    // prints the SQL Exception
//    public static void printSQLException(SQLException ex) {
//        for (Throwable e : ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
//    }


	@Override
	public int getNumberOfSeats(String slotId) {
		// TODO Auto-generated method stub
		return 0;
	}
}