/**
 * Assignment 4
 * Backup System for Student Records
 * Programmer- Chetan Badhe
 */
package studentBackup.util;

/**
 * @author Chetan
 *
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
