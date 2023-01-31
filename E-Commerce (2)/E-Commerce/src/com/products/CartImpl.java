package com.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ConnectionP.ConnectionProvider;


public class CartImpl implements Cart {
	

	@Override
	public void buyProducts(List<Productdetails> al, int uid) {
		 Connection con = ConnectionProvider.getConnection();
		
		for (int i = 0; i < al.size(); i++) {
			Productdetails productdetails = new Productdetails();
			productdetails = al.get(i);
		
			int id = productdetails.getProductid();
			String name = productdetails.getName();
			String desc = productdetails.getDescription();
			double price = productdetails.getPrice();
			int quantity =productdetails.getQuantity();
			
		
			
			  try {
				PreparedStatement ps = con.prepareStatement("Insert into cart (cart_id,pdesciption,price,pname,quantity)values(?,?,?,?,?");
				ps.setInt(1, id);
				ps.setString(2, desc);
				ps.setDouble(3, price);
				ps.setString(4, name);
				ps.setInt(5, quantity);
				int record =ps.executeUpdate();
				if (record>0) {
					
					System.out.println("Successfully Updated Into Cart "+record);
				
				}
			
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	
		
	}
	public static void main(String[] args) {
		
		
	}

	
		
	}
