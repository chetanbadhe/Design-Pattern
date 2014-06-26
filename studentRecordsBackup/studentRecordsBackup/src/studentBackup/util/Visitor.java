/**
 * Assignment 4
 * Backup System for Student Records
 * Programmer- Chetan Badhe
 */
package studentBackup.util;

import studentBackup.bst.Node;

/**
 * @author Chetan
 *
 */
public interface Visitor {
	/**
	 * Vist node
	 * @param node
	 */
	public void visit(Node node);
}
