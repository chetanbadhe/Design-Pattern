/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reflection.util;

/**
 *
 * @author ChetanBadhe
 */
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
