/**
 * Subject : CS542 - Programming Design Pattern
 * Homework : 1
 * Author : Chetan Badhe, Yash Desai.
 * File Name : Debug.java
 * Description : Debug
 */
package dTunesStore.util;

public class Debug {
    private static int DEBUG_VALUE;

    /**
     * 
     * @return : int
     */
	public static int getDEBUG_VALUE() {
		return DEBUG_VALUE;
	}

	/**
	 * 
	 * @return : void 
	 */
	public static void setDEBUG_VALUE(int dEBUG_VALUE) {
		DEBUG_VALUE = dEBUG_VALUE;
	}

	/**
	 * 
	 * @return : void
	 */
    public static void println(int debugValue, String msg)
    {
    	if (debugValue == DEBUG_VALUE)
    	{
    		System.out.println(msg);
    	}
    }
    

}