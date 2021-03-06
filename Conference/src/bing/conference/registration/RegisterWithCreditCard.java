package bing.conference.registration;

import bing.conference.carbon.CarbonInTonnes;
import bing.conference.carbon.CarbonInterface;
import bing.conference.cost.CostInDollars;
import bing.conference.cost.CostInterface;
import bing.conference.dpconference.CarbonFactory;
import bing.conference.dpconference.CostFactory;
import bing.conference.dpconference.TimeFactory;
import bing.conference.time.TimeInMinutes;
import bing.conference.time.TimeInterface;

public class RegisterWithCreditCard implements RegisterInterface {

	private CostInterface cost;
	private TimeInterface time;
	private CarbonInterface carbon;
	
	public RegisterWithCreditCard(){
		cost = CostFactory.createCostObject("dollar");
		time = TimeFactory.createTimeObject("minutes");
		carbon = CarbonFactory.createCarbonObject("tonnes");
		
		cost.setCost(50);
		time.setTime(20);
		carbon.setCarbon(10);
		
	}
	@Override
	public boolean doRegistration() {
		// TODO Auto-generated method stub
		
		CostInDollars costD = (CostInDollars) cost.getCostObject();
		TimeInMinutes timeM = (TimeInMinutes)time.getTimeObject();
		CarbonInTonnes carbonT = (CarbonInTonnes)carbon.getCarbonObject();
		
		System.out.println("Registration Done Successfully !!!"+"with \n Cost: $" +costD.getCostValue()+"\n Time: "+timeM.getTimeValue()+"\n Carbon Footprint: "+carbonT.getCarbonValue()+"\n\n");
		
		return true;
	}
	@Override
	public boolean isRegistered() {
		// TODO Auto-generated method stub
		return false;
	}

}
