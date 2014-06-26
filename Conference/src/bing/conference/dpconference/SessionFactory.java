package bing.conference.dpconference;

import bing.conference.sessions.Session1;
import bing.conference.sessions.Session2;
import bing.conference.sessions.Session3;
import bing.conference.sessions.SessionInterface;


public class SessionFactory {

	
	 public static SessionInterface createSession (String sessionName) {
		    if (sessionName. equalsIgnoreCase ("session1")){
		           return new Session1();
		    }else if(sessionName. equalsIgnoreCase ("session2")){
		           return new Session2();
		    }else if(sessionName. equalsIgnoreCase ("session3")){
		           return new Session3();
		     }
		    throw new IllegalArgumentException("No such Session !!!");
		    }
}
