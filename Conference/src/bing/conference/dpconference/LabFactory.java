package bing.conference.dpconference;

import bing.conference.labs.Lab1;
import bing.conference.labs.Lab2;
import bing.conference.labs.Lab3;
import bing.conference.labs.LabsInterface;


public class LabFactory {
	
	public static LabsInterface createLabs (String LabName) {
	    if (LabName. equalsIgnoreCase ("Lab1")){
	           return new Lab1();
	    }else if(LabName. equalsIgnoreCase ("Lab2")){
	           return new Lab2();
	    }else if(LabName. equalsIgnoreCase ("Lab3")){
	           return new Lab3();
	     }
	    throw new IllegalArgumentException("No such Session !!!");
	    }

}
