package com.objects;

import org.springframework.stereotype.Component;

@Component
public class CliSubscriptionStandard implements CliSubscription {
	

	@Override
	public String getSubscriptionName() {
		return "Client Standard Subscription";
	}

}
