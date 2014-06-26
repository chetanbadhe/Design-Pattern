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
public class BSTObserver implements Observer{
	
	@Override
	public void update(int newValue){
		System.out.println("Observer");
	}
}
