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
public class BSTSumVisitor implements Visitor{

	@Override
	public void visit(Node node) {
		// TODO Auto-generated method stub
		sumVisit(node);
	}

	/**
	 * Get the sum of tree visited
	 * @param bst
	 */
	public void sumVisit(Node node) {
		// TODO Auto-generated method stub
		String msg = "Sum = " + sumNodeValue(node)+ System.getProperty("line.separator");
		Debug.println(2, msg);
		Debug.println(5, msg);
	}

	/**
	 * Calculate sum of values of the all nodes in the tree
	 */
	public int sumNodeValue(Node node){
		int sum = 0;
		if(node == null)
			return 0;
		else{
			sum += sumNodeValue(node.getLeft());
			sum += node.getVal();
			sum += sumNodeValue(node.getRight());
		}
		return sum;
	}
	
	
}
