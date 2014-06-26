/**
 * Assignment 4
 * Backup System for Student Records
 * Programmer- Chetan Badhe
 */
package studentBackup.driver;

import java.io.File;

import studentBackup.bst.BSTBuilder;
import studentBackup.util.Debug;

/**
 * @author Chetan
 *
 */
public class driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length == 3){
			File bstifile = new File(System.getProperty("user.dir") + "//" + args[0]);
			int UPDATE_VALUE = Integer.parseInt(args[1]);
			int debug = Integer.parseInt(args[2]);
			if(bstifile.exists() && debug > 0 && debug < 6){
				BSTBuilder bstbuilder = new BSTBuilder(args[0], UPDATE_VALUE);
				Debug.setDEBUG_VALUE(Integer.parseInt(args[2]));
				bstbuilder.buildTree();
				bstbuilder.getSumOfAllTree();
				bstbuilder.updateTree();
				bstbuilder.getSumOfAllTree();
			}
			else{
				System.err.println("File doesnot exists or debug value is not in range!!!");
				System.exit(0);
			}
		}
		else{
			System.err.println("Illegal arguments exception!!!");
			System.exit(0);
		}
	}
}
