package com.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Tomasz Gomoradzki
 * Client Account Object Bean interface implementation
 *
 */

@Component("ClientAccountPremium")
@Scope("singleton") /** Singleton is used in Spring by default, left for the reference and code clarity **/
public class ClientAccountPremium implements ClientAccount {
	
	/** Configuring dependency injection with @Autowired annotation (Field Option) **/
	@Autowired
	@Qualifier("cliSubscriptionPremium")
	private CliSubscription cliSubscription;
	
	/** Configuring dependency injection with @Autowired annotation (Constructor Option) **/
	//@Autowired
	//public ClientAccountPremium (	@Qualifier("cliSubscriptionPremium") CliSubscription clientSubscription) {
	//	cSubscription = clientSubscription;
	//}
	
	public ClientAccountPremium() {		
	}

	@Override
	public String getAccountTypeName() {
		return "Premium Client Account";
	}

	@Override
	public String getSubscriptionName() {
		return cliSubscription.getSubscriptionName();
	}

}
