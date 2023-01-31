package com.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.ConnectionP.ConnectionProvider;

public class ProductImpl implements Products {
	@Override
	public void getProductDetails() {
		Connection con = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("Select * from product ");
			ResultSet rs = ps.executeQuery();
			// System.out.println("ID"+" || "+"Description"+" || "+"Price"+" || "+"Name"+"
			// || "+"Quantity");

			while (rs.next()) {
				System.out.println(" ID : " + rs.getString(1) + " Description : " + rs.getString(2) + " Price : "
						+ rs.getString(3) + " Name : " + rs.getString(4) + " Quantity : " + rs.getString(5));
				System.out.println("*************************************");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void serachByName(int uid) {
	
		List<Productdetails> aList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		boolean flag = false;
		int count = 0;

		Connection con = ConnectionProvider.getConnection();
		try {

			while (true) {

				System.out.println("Enter name of Product");
				String name = scanner.next();
				PreparedStatement ps = con.prepareStatement("Select * from product ");
				ResultSet rs = ps.executeQuery();
				flag=false;
				

				while (rs.next()) {

					if (name.equals(rs.getString("name"))) {
						Productdetails productdetails = new Productdetails();
						productdetails.setProductid(rs.getInt(1));
						productdetails.setDescription(rs.getString(2));
						productdetails.setPrice(rs.getInt(3));
						productdetails.setName(rs.getNString(4));
						productdetails.setQuantity(rs.getInt(5));
						aList.add(productdetails);
						count++;
						flag = true;
						System.out.println("Want To Buy More Product >> Press 1");
						int key = scanner.nextInt();
						if (key == 1) {
							flag = true;

						} else {
							flag = false;

							break;
						}

					}

				}
				if (flag == true) {
					continue;
				} else {
					break;
				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		Iterator<Productdetails> i = aList.iterator();
		while (i.hasNext()) {

			System.out.println(i.next());
		}
		CartImpl cartImpl = new CartImpl();
		cartImpl.buyProducts(aList,uid);

	}

	public static void main(String[] args) {
		ProductImpl productImpl = new ProductImpl();
		// productImpl.getProductDetails();
		productImpl.serachByName();

	}

}
