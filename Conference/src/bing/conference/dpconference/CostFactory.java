package bing.conference.dpconference;

import bing.conference.cost.CostInDollars;
import bing.conference.cost.CostInterface;


public class CostFactory {

	public static CostInterface createCostObject (String costType) {
	    if (costType. equalsIgnoreCase ("dollar")){
	           return new CostInDollars();
	    }
	    throw new IllegalArgumentException("No such Cost type supported!!!");
	    }
}
