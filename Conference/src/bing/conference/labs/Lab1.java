package bing.conference.labs;

import bing.conference.carbon.CarbonInTonnes;
import bing.conference.carbon.CarbonInterface;
import bing.conference.cost.CostInDollars;
import bing.conference.cost.CostInterface;
import bing.conference.dpconference.CarbonFactory;
import bing.conference.dpconference.CostFactory;
import bing.conference.dpconference.TimeFactory;
import bing.conference.time.TimeInMinutes;
import bing.conference.time.TimeInterface;

public class Lab1 implements LabsInterface{

	private CostInterface cost;
	private TimeInterface time;
	private CarbonInterface carbon;
	
	public Lab1(){
		cost = CostFactory.createCostObject("dollar");
		time = TimeFactory.createTimeObject("minutes");
		carbon = CarbonFactory.createCarbonObject("tonnes");
		
		cost.setCost(50);
		time.setTime(20);
		carbon.setCarbon(5);
		
	}
	@Override
	public void visitLabs() {
		
		CostInDollars costD = (CostInDollars) cost.getCostObject();
		TimeInMinutes timeM = (TimeInMinutes)time.getTimeObject();
		CarbonInTonnes carbonT = (CarbonInTonnes)carbon.getCarbonObject();
		
		System.out.println("Lab1 Visited with:\n Cost: $" +costD.getCostValue()+"\n Time: "+timeM.getTimeValue()+"\n Carbon Footprint: "+carbonT.getCarbonValue()+"\n\n");
	}

	
}
