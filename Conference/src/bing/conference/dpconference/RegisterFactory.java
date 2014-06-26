package bing.conference.dpconference;

import bing.conference.registration.RegisterInterface;
import bing.conference.registration.RegisterWithCreditCard;


public class RegisterFactory {

	
	  public static RegisterInterface createRegister (String registerMethod) {
		    if (registerMethod. equalsIgnoreCase ("creditcard")){
		           return new RegisterWithCreditCard();
		    }
		    throw new IllegalArgumentException("No such Restaurant !!!");
		    }
}
