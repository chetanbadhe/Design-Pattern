package bing.conference.driver;

import bing.conference.dpconference.LabFactory;
import bing.conference.dpconference.RegisterFactory;
import bing.conference.dpconference.RestaurantFactory;
import bing.conference.dpconference.SessionFactory;
import bing.conference.dpconference.checkList;
import bing.conference.labs.LabsInterface;
import bing.conference.registration.RegisterInterface;
import bing.conference.restaurants.RestuarantInterface;
import bing.conference.sessions.SessionInterface;

public class Driver {

	private RegisterInterface register;
	private LabsInterface labs;
	private SessionInterface sessions;
	private RestuarantInterface restaurants;
	
	public static void main(String[] args) {
		
		Driver driver = new Driver();
		
		 RegisterInterface register= driver.getRegister();
		 LabsInterface labs = driver.getLabs();
		 SessionInterface sessions = driver.getSession();
		RestuarantInterface restaurant = driver.getRestaurant();

		checkList cl = new checkList(register, labs, sessions, restaurant);
		
		cl.completeCheckList();
		
	}
	
	
	public RegisterInterface getRegister(){
		
		return register = RegisterFactory.createRegister("creditcard");
	}

	public LabsInterface getLabs(){
		
		return labs = LabFactory.createLabs("Lab1");
	}
	
	public SessionInterface getSession(){
		
		return sessions = SessionFactory.createSession("session1");
	}

	public RestuarantInterface getRestaurant(){
		
		return restaurants = RestaurantFactory.createRestaurant("No5");
	}

}
