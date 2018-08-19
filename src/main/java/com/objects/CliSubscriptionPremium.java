package com.objects;

import org.springframework.stereotype.Component;

@Component
public class CliSubscriptionPremium implements CliSubscription {
	
	@Override
	public String getSubscriptionName() {
		
		return "Client Premium Subscription";
	}

}
