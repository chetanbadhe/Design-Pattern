/**
 * Assignment 4
 * Backup System for Student Records
 * Programmer- Chetan Badhe
 */
package studentBackup.bst;


import studentBackup.util.BSTUpdateVisitor;
import studentBackup.util.Visitor;

/**
 * @author Chetan
 *
 */
public class BST implements BSTTree{

	private Node root = null;
	private int UPDATE_VAL = -1;
	private String bstname = null;

	/**
	 * @return the root
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(Node root) {
		this.root = root;
	}

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
	 * @return the bstname
	 */
	public String getBstname() {
		return bstname;
	}

	/**
	 * @param bstname the bstname to set
	 */
	public void setBstname(String bstname) {
		this.bstname = bstname;
	}
	
	/**
	 * Constructor
	 */
	public BST(int val, String bstname){
		setRoot(null);
		setUPDATE_VAL(val);
		setBstname(bstname);
	}

	@Override
	public Node addNode(Node node , int value) {
		if(node == null)
			node = new Node(value);
		else if(node.getVal() > value)
			node.setLeft(addNode(node.getLeft(), value));
		else if(node.getVal() < value)
			node.setRight(addNode(node.getRight(), value));
		return node;
	}

	@Override
	public void updateNode(Node node) {
		// TODO Auto-generated method stub
		if(node == null)
			return;
		else{
			updateNode(node.getLeft());
			Visitor bstvisitable = new BSTUpdateVisitor(UPDATE_VAL);
			node.accept(bstvisitable);
			updateNode(node.getRight());
		}
	}

	@Override
	public String printBSTTree(Node node) {
		// TODO Auto-generated method stub
		String msg = null;
		if(node == null)
			return "";
		else{
			msg += printBSTTree(node.getLeft());
			//System.out.println(node.getVal());
			msg += node.getVal()+ ",";
			msg += printBSTTree(node.getRight());
		}
		return msg.replace("null", "");
	}

	@Override
	public boolean isEmpty() {
		if(root == null)
			return true;
		return false;
	}

	@Override
	public int isPresent(Node node, int oldValue) {
		if(node == null)
			return -1;
		else if(node.getVal() > oldValue)
			return isPresent(node.getLeft(), oldValue);
		else if(node.getVal() < oldValue)
			return isPresent(node.getRight(), oldValue);
		else   
			return node.getVal();
	}

	
	/**
	 * Search for node of said value
	 * @param node
	 * @param value
	 * @return node
	 */
	public Node getNode(Node node, int value){
		Node n = null;
		if(node.getVal() == value){
			n = node;
		}
		else if(node.getVal() > value){
			n = getNode(node.getLeft(), value);
		}
		else if(node.getVal() < value){
			n = getNode(node.getRight(), value);
		}	
		return n;
	}

	/**(non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BST [root=" + root + ", UPDATE_VAL=" + UPDATE_VAL
				+ ", bstname=" + bstname + "]";
	}

	
}
