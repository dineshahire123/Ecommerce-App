package com.main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.products.ProductImpl;
import com.products.Productdetails;
import com.registration.*;


public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UserLogin flag = null;
		
		
		while (true) {
		
			
		
		System.out.println("If You Are New User >> Press 1");
		System.out.println("If You Are Already Register >> Press 2");
		int i = scanner.nextInt();
		
		
		if (i==1) {
			Registration registration = new Registration();
			registration.getRegistrationDetails();
			
		}else if (i==2) {
			Login login = new Login();
			flag=login.getUserDetails();
			if (flag!=null) {
				break;
				
			}else {
				System.out.println("Please Enter Correct Details");
				continue;
			}
			
			
		}
		else{
			System.out.println("Wrong Information");
		}
		
		}
		if (flag!=null) {
			ProductImpl productImpl = new ProductImpl();
			productImpl.getProductDetails();
			
			
			productImpl.serachByName(flag.getUid());
		
			
			
		}
		
	}

}
