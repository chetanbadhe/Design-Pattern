package bing.conference.dpconference;

import bing.conference.cost.CostInDollars;
import bing.conference.cost.CostInterface;
import bing.conference.time.TimeInMinutes;
import bing.conference.time.TimeInterface;

public class TimeFactory {

	
	public static TimeInterface createTimeObject (String timeType) {
	    if (timeType. equalsIgnoreCase ("minutes")){
	           return new TimeInMinutes();
	    }
	    throw new IllegalArgumentException("No such Time type supported!!!");
	    }
}
