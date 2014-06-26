package bing.conference.restaurants;

import bing.conference.carbon.CarbonInTonnes;
import bing.conference.carbon.CarbonInterface;
import bing.conference.cost.CostInDollars;
import bing.conference.cost.CostInterface;
import bing.conference.dpconference.CarbonFactory;
import bing.conference.dpconference.CostFactory;
import bing.conference.dpconference.TimeFactory;
import bing.conference.time.TimeInMinutes;
import bing.conference.time.TimeInterface;

public class LemonGrassRestaurants implements RestuarantInterface {

	private CostInterface cost;
	private TimeInterface time;
	private CarbonInterface carbon;
	
	public LemonGrassRestaurants(){
		cost = CostFactory.createCostObject("dollar");
		time = TimeFactory.createTimeObject("minutes");
		carbon = CarbonFactory.createCarbonObject("tonnes");
		
		cost.setCost(35);
		time.setTime(20);
		carbon.setCarbon(10);
		
	}
	@Override
	public void visitRestaurant() {
		// TODO Auto-generated method stub
		
		CostInDollars costD = (CostInDollars) cost.getCostObject();
		TimeInMinutes timeM = (TimeInMinutes)time.getTimeObject();
		CarbonInTonnes carbonT = (CarbonInTonnes)carbon.getCarbonObject();
		
		System.out.println("LemonGrass Visited with Cost: $" +costD.getCostValue()+" Time: "+timeM.getTimeValue()+" Carbon Footprint: "+carbonT.getCarbonValue());
	}
}
