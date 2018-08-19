package com.objects;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ClientAccountStandard")
@Scope("singleton") // @Scope("prototype"), singleton is set by default, left for the reference and code clarity
public class ClientAccountStandard implements ClientAccount {
	
		// Configuring dependency injection with @Autowired annotation (Field Option)
	@Autowired
	@Qualifier("cliSubscriptionStandard")
	private CliSubscription cliSubscription;
		
		// Configuring dependency injection with @Autowired annotation (Constructor Option)
	//	@Autowired
	//	public ClientAccountStandard (@Qualifier("cliSubscriptionStandard") CliSubscription clientSubscription) {
	//		cliSubscription = clientSubscription;
	//	}
	
	public ClientAccountStandard () {	
	}
	

	@Override
	public String getAccountTypeName() {
		return "Standard Client Account";
	}

	@Override
	public String getSubscriptionName() {
		return cliSubscription.getSubscriptionName();
	}
	
		//life cycle method annotation, launched at the the start of bean
	@PostConstruct
	public void CliAccountBeanStart() {
		System.out.println("Bean Client Account Standard has been started.");
	}
	
	@PreDestroy
	public void CliAccountBeanEnd(){
		System.out.println("Bean Client Account Standard has been destroyed.");
	}

}
