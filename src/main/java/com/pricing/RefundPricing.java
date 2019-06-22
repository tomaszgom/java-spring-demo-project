package com.pricing;

import com.entity.PurchaseOrder;

/**
 * 
 * ProductPricing Object Bean interface to handle refunds business logic
 *
 */

public interface RefundPricing {
	
	public double getPurchaseOrderRefundFactor(PurchaseOrder purchaseOrder);

}
