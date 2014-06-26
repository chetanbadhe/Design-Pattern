package bing.conference.dpconference;

import bing.conference.carbon.CarbonInTonnes;
import bing.conference.carbon.CarbonInterface;
import bing.conference.cost.CostInDollars;
import bing.conference.cost.CostInterface;

public class CarbonFactory {
	
	public static CarbonInterface createCarbonObject (String carbonType) {
	    if (carbonType. equalsIgnoreCase ("tonnes")){
	           return new CarbonInTonnes();
	    }
	    throw new IllegalArgumentException("No such Carbon type supported!!!");
	    }

}
