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
public interface Subject {
	/**
	 * Register observer
	 * @param observer
	 */
	public void registerObserver(Observer observer);
	
	/**
	 * Remove obsserver
	 * @param observer
	 */
	public void removeObserver(Observer observer);
	
	/**
	 * Notify observers
	 */
	public void notifyObservers();
}
