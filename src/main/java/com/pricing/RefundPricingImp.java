package com.pricing;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.entity.PurchaseOrder;

/**
 * 
 * Class used to calculate Purchase Order pricing refund
 *
 */
@Component("RefundPricingImp")
public class RefundPricingImp implements RefundPricing {
	
	private Calendar outdated30 = Calendar.getInstance();
	private Calendar outdated60 = Calendar.getInstance();
	private Calendar outdated90 = Calendar.getInstance();
		
	public RefundPricingImp(){
		this.outdated30.add(Calendar.DAY_OF_MONTH, -30);
		this.outdated60.add(Calendar.DAY_OF_MONTH, -60);
		this.outdated90.add(Calendar.DAY_OF_MONTH, -90);
	}
	
	/**
	 * Calculating refund for outdated purchase order, depending on how much it is outdated and the Purchase order value
	 * @param purchaseOrder
	 * @return Refund number as percentage of price to be returned for Client
	 */
	@Override
	public double getPurchaseOrderRefundFactor(PurchaseOrder purchaseOrder) {
		
		Date dateOutdated30 = this.outdated30.getTime();
		Date dateOutdated60 = this.outdated60.getTime();
		Date dateOutdated90 = this.outdated90.getTime();
		
		int priceRefundFactor = 0;
		
		if(purchaseOrder.getOrderDate().before(dateOutdated90)) {
			priceRefundFactor += 20;
		}else if (purchaseOrder.getOrderDate().before(dateOutdated60)) {
			priceRefundFactor += 15;
		}else if (purchaseOrder.getOrderDate().before(dateOutdated30)) {
			priceRefundFactor += 5;
		}
		
		if(purchaseOrder.getOrderValue()>2000) {
			priceRefundFactor += 20;
		}else if (purchaseOrder.getOrderValue()>1000 ) {
			priceRefundFactor += 10;
		}else if (purchaseOrder.getOrderValue()>700 && purchaseOrder.getOrderDate().before(dateOutdated60)) {
			priceRefundFactor += 5;
		}
		
		return priceRefundFactor/100;
			
	}
	

}
