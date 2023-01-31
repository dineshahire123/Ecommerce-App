package com.registration;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ConnectionP.ConnectionProvider;



public class Registration {
	public boolean getRegistrationDetails() {

		System.out.println("Enter Registration Details>> ");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter email");
		String email = scanner.next();
		
		System.out.println("Enter Password");
		String password =scanner.next();
		UserDetails ud = new UserDetails();
		
		
		ud.setEmail(email);
		
		ud.setPassword(password);
		Connection con = ConnectionProvider.getConnection();
		try {
		PreparedStatement ps = con.prepareStatement("Insert into user (email, password)values(?,?)");
		
		
		ps.setString(1, ud.getEmail());
		
		ps.setString(2, ud.getPassword());
		int i= ps.executeUpdate();
		if (i>0) {
			System.out.println("User Register Succesfully " +i);
			return true;
		}
		
	PreparedStatement ps1 = con.prepareStatement("Select * from user");
	ResultSet rs = ps1.executeQuery();
	while(rs.next()){
		
		System.out.println(rs.getString(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getString(3));
		
		System.out.println("******************");
	}
		con.close();
		rs.close();
		ps.close();
		ps1.close();
		//scanner.close();
		
			
			
		
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
		
		

	}
	
	public static void main(String[] args) {
		Registration registration = new Registration();
		registration.getRegistrationDetails();
		
	}


}
