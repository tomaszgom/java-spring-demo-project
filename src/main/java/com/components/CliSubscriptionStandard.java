package com.components;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Tomasz Gomoradzki
 * Client Subscription Object Bean interface implementation
 *
 */

@Component
public class CliSubscriptionStandard implements CliSubscription {
	

	@Override
	public String getSubscriptionName() {
		return "Client Standard Subscription";
	}

}
