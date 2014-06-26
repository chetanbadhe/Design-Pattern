/**
 * Assignment 4
 * Backup System for Student Records
 * Programmer- Chetan Badhe
 */
package studentBackup.bst;

/**
 * @author Chetan
 * Interface for BSTTree
 */
public interface BSTTree {
	/**
	 * Check if Tree is empty and has no node is present
	 * @return boolean
	 */
	public boolean isEmpty();
	
	/**
	 * Create and Insert node in tree
	 * @param node
	 * @param value
	 * @return node
	 */
	public Node addNode(Node node, int value);
	
	/**
	 * Update said node value
	 * @param node
	 */
	public void updateNode(Node node); 
	
	/**
	 * Check if node of said value exist in Tree
	 * @param node
	 * @param oldValue
	 * @return
	 */
	public int isPresent(Node node, int oldValue);
	
	/**
	 * Print the said Tree
	 * @param node
	 */
	public String printBSTTree(Node node);
}
