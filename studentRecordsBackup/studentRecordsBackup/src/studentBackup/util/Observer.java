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
public interface Observer {
	
	/**
	 * Update the value of node visited by visitor
	 * @param newValue
	 */
	public void update(int newValue);
}
