package com.pricing;

import com.entity.Client;
import com.entity.Product;
import com.entity.PurchaseOrder;

/**
 * 
 * ProductPricing Object Bean interface to handle product pricing and discounts
 *
 */

public interface ProductPricing {
	
	public double getPurchaseOrderPriceFactor(Product product, PurchaseOrder purchaseOrder);

	public double getClientPriceDiscount(Client client);
	
}