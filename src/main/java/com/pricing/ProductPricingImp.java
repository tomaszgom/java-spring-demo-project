package com.pricing;

import org.springframework.stereotype.Component;

import com.entity.Client;
import com.entity.Product;
import com.entity.PurchaseOrder;

/**
 * 
 * Class used to calculate product pricing, used to calculate price component for product
 *
 */

@Component("ProductPricingImp")
public class ProductPricingImp implements ProductPricing {
	
	
	public ProductPricingImp(){
	
	}
	
	@Override
	public double getPurchaseOrderPriceFactor(Product product, PurchaseOrder purchaseOrder) {
		
		int priceFactor = 0;
		
		if(purchaseOrder.getOrderValue()>2000) {
			priceFactor += 10;
		}else if (purchaseOrder.getOrderValue()>1000) {
			priceFactor += 5;
		}else if (purchaseOrder.getOrderValue()>700) {
			priceFactor += 2;
		}
		
		return priceFactor/100;
			
	}
	
	// Returns double representing Client's percentage discount
	@Override
	public double getClientPriceDiscount(Client client){
		
		int percentageDiscount = 0;
		
		// Incrementing discount percentage depending on how many points Client has
		if (client.getPoints() > 300) {
			percentageDiscount += 6;
		} else if (client.getPoints() > 200) {
			percentageDiscount += 4;
		} else if (client.getPoints() > 100) {
			percentageDiscount += 2;
		}
		
		// Incrementing discount percentage depending on how many products Client has
		// bought
		if (client.getPurchaseOrders().isEmpty() == false) {
			if (client.getPurchaseOrders().size() > 50) {
				percentageDiscount += 12;
			} else if (client.getPurchaseOrders().size() > 20) {
				percentageDiscount += 6;
			} else if (client.getPurchaseOrders().size() > 10) {
				percentageDiscount += 3;
			}

		}
		
		return percentageDiscount/100;
	}

}
