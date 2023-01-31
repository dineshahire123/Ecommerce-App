package com.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ConnectionP.ConnectionProvider;
import com.sun.org.apache.regexp.internal.recompile;

public class Login {

//Taking input from user  For Login

	public UserLogin getUserDetails() {
		ResultSet rs = null;
		System.out.println("Enter Details For Uset Login");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Email");
		String email = scanner.next();
		System.out.println("Enter Password");
		String pass = scanner.next();
		UserLogin ul = new UserLogin();
		ul.setEmail(email);
		ul.setPass(pass);
		
		UserLogin ul2 = new UserLogin();
		ul2=null;

		// Connection establish

		Connection con = ConnectionProvider.getConnection();
		try {
			// prepared Statement

			PreparedStatement ps = con.prepareStatement("Select * from user");
			rs = ps.executeQuery();
			boolean flag = false;
			while (rs.next()) {

				// checking login input with database records

				if (rs.getString(2).equals(ul.getEmail()) && (rs.getString(3).equals(ul.getPass()))) {
					ul2.setUid(rs.getInt(1));
					ul2.setEmail(rs.getString(2));
					ul2.setPass(rs.getString(3));

					flag = true;

					break;

				} 
				else {
					flag = false;

				}

			}
			if (flag == true) {
				System.out.println("Login Successfully");
				return ul2;
			} 
			else {
				
				return null;

			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] args) {
		Login login = new Login();
		login.getUserDetails();

	}
	

}
