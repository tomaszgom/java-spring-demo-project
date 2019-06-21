package com.pricing;

import java.util.Calendar;

import com.entity.Product;
import com.entity.PurchaseOrder;

/**
 * 
 * Class used to calculate product pricing factor, used to calculate final proce for product
 *  @in progress
 *
 */

public class ProductPricing {
	
	private Calendar today = Calendar.getInstance();
	
	public ProductPricing(){
		today.set(Calendar.HOUR_OF_DAY, 0); // same for minutes and seconds		
	}
	
	public double getPriceFactor(Product product, PurchaseOrder purchaseOrder) {
		
		
		if(purchaseOrder.getOrderDate() == null) {
			return 1;
		}else {
			return 1;
		}
		
		
		
	}

}
