package bing.conference.dpconference;

import bing.conference.labs.LabsInterface;
import bing.conference.registration.RegisterInterface;
import bing.conference.restaurants.RestuarantInterface;
import bing.conference.sessions.SessionInterface;

public class checkList {

	private RegisterInterface register;
	private LabsInterface labs;
	private SessionInterface sessions;
	private RestuarantInterface restaurants;
	
	
	public checkList(RegisterInterface register, LabsInterface labs,
			SessionInterface sessions, RestuarantInterface restaurants) {
		super();
		this.register = register;
		this.labs = labs;
		this.sessions = sessions;
		this.restaurants = restaurants;
	}


	public void completeCheckList(){
		
		register.doRegistration();
		labs.visitLabs();
		sessions.visitSession();
		restaurants.visitRestaurant();
		
	}
}
