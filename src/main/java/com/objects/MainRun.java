package com.objects;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainRun {
	
	public static void main (String[] args) {
		
			// read the config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			// get the bean
		ClientAccount cAccount = context.getBean("ClientAccountStandard", ClientAccount.class);
		
		System.out.println(cAccount.getAccountTypeName());
		
		System.out.println(cAccount.getSubscriptionName());
		
		context.close();
		
		
		Double dob = new Double(12.454545);
	      
		String stat = String.format("%.1f", dob); 
		System.out.println(stat);
	      
	      // Deposit 1000 into Zara's account
	      //double balance = ((Double)hm.get("Zara")).doubleValue();
	      //hm.put("Zara", new Double(balance + 1000));
	      //System.out.println("Zara's new balance: " + hm.get("Zara"));
		
	}

}
