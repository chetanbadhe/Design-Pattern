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
public class BSTUpdateVisitor implements Visitor{

	private int UPDATE_VAL = -1;

	/**
	 * @return the uPDATE_VAL
	 */
	public int getUPDATE_VAL() {
		return UPDATE_VAL;
	}

	/**
	 * @param uPDATE_VAL the uPDATE_VAL to set
	 */
	public void setUPDATE_VAL(int uPDATE_VAL) {
		UPDATE_VAL = uPDATE_VAL;
	}

	/**
	 * Constructor
	 * @param bvisit
	 * @param VAL
	 */
	public BSTUpdateVisitor(int VAL){
		setUPDATE_VAL(VAL);
	}


	@Override
	public void visit(Node node) {
		// TODO Auto-generated method stub
		updateVisit(node,getUPDATE_VAL());
	}
	
	/**
	 * Update the node visited 
	 * @param bst
	 * @param UPDATE_VAL
	 */
	public void updateVisit(Node node , int UPDATE_VAL) {
		node.update(UPDATE_VAL);
	}
}
