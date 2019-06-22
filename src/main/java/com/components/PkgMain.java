package com.components;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * PackageMain Class
 * Working class for testing purposes, left for reference
 */

public class PkgMain {
	
	public static void main (String[] args) {
		
		// Read the config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Get the bean
		ClientAccount cAccount = context.getBean("ClientAccountStandard", ClientAccount.class);
		
		System.out.println(cAccount.getAccountTypeName());
		
		System.out.println(cAccount.getSubscriptionName());
		
		context.close();
		
		
		Double dob = new Double(12.454545);
	      
		String stat = String.format("%.1f", dob); 
		System.out.println(stat);
	      
	      // Deposit 1000 into Zara's account
	      // double balance = ((Double)hm.get("Zara")).doubleValue();
	      // hm.put("Zara", new Double(balance + 1000));
	      // System.out.println("Zara's new balance: " + hm.get("Zara"));
		
	}

}
