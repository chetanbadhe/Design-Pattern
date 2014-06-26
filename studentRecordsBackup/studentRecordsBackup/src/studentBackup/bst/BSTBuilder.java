/**
 * Assignment 4
 * Backup System for Student Records
 * Programmer- Chetan Badhe
 */
package studentBackup.bst;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import studentBackup.util.BSTSumVisitor;
import studentBackup.util.Debug;
import studentBackup.util.Visitor;

/**
 * @author Chetan
 *
 */
public class BSTBuilder {

	private BufferedReader br = null;
	private String filename = null;
	private BST originalTree = null;
	private BST bckTree1 = null;
	private BST bckTree2 = null;

	/**
	 * @return the originalTree
	 */
	public BST getOriginalTree() {
		return originalTree;
	}

	/**
	 * @param originalTree the originalTree to set
	 */
	public void setOriginalTree(BST originalTree) {
		this.originalTree = originalTree;
	}

	/**
	 * @return the bckTree1
	 */
	public BST getBckTree1() {
		return bckTree1;
	}

	/**
	 * @param bckTree1 the bckTree1 to set
	 */
	public void setBckTree1(BST bckTree1) {
		this.bckTree1 = bckTree1;
	}

	/**
	 * @return the bckTree2
	 */
	public BST getBckTree2() {
		return bckTree2;
	}

	/**
	 * @param bckTree2 the bckTree2 to set
	 */
	public void setBckTree2(BST bckTree2) {
		this.bckTree2 = bckTree2;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the br
	 */
	public BufferedReader getBr() {
		return br;
	}

	/**
	 * @param br the br to set
	 */
	public void setBr(BufferedReader br) {
		this.br = br;
	}

	/**
	 * Constructor
	 */
	public BSTBuilder(String filename, int UPDATE_VALUE){
		try {
			setFilename(filename);
			setBr(new BufferedReader(new FileReader(
					System.getProperty("user.dir") + "//" +
							getFilename())));
			setOriginalTree(new BST(UPDATE_VALUE,"Original Tree" ));
			setBckTree1(new BST(UPDATE_VALUE, "Backup Tree1"));
			setBckTree2(new BST(UPDATE_VALUE, "Backup Tree2"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("BSTBuilder exception - " + e);
			System.exit(0);
		}
	}

	/**
	 * Build Tree and register observers nodes
	 */
	public void buildTree() {
		int value = -1;
		try{
			while((value = getRecord())!=-1){
				if(getOriginalTree().isPresent(getOriginalTree().getRoot(), value)==-1){
					getOriginalTree().setRoot(getOriginalTree().
							addNode(getOriginalTree().getRoot(), value));
					getBckTree1().setRoot(getBckTree1().addNode
							(getBckTree1().getRoot(), value));
					getBckTree2().setRoot(getBckTree2().addNode
							(getBckTree2().getRoot(), value));
					Node node = getOriginalTree().getNode(getOriginalTree().getRoot(), value);
					Node node1 = getBckTree1().getNode(getBckTree1().getRoot(), value);
					Node node2 = getBckTree2().getNode(getBckTree2().getRoot(), value);
					node.registerObserver(node1);
					node.registerObserver(node2);
				}
				else{
					throw new IllegalArgumentException("Node already exist!!!");
				}
			}
			Debug.println(1, printTree());
			Debug.println(5, printTree());
		}catch(Exception e){
			System.err.println(e.getMessage());
			System.exit(0);
		}
	}

	/**
	 * Read File records
	 */
	public int getRecord(){
		String getline = null;
		try {
			if((getline = getBr().readLine())!= null){
				return Integer.parseInt(getline);
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.err.println("BSTBuilder class exception - " + e);
			System.exit(0);
		}
		return -1;
	}

	/**
	 * Print All tree
	 */
	public String printTree(){
		String msg = "---------------------------" +getOriginalTree().getBstname()+
				"---------------------------" +  System.getProperty("line.separator");
		msg += getOriginalTree().printBSTTree(
				getOriginalTree().getRoot()) + System.getProperty("line.separator");
		msg += "---------------------------" +getBckTree1().getBstname()+
				"---------------------------" + System.getProperty("line.separator");
		msg += getBckTree1().printBSTTree(
				getBckTree1().getRoot()) + System.getProperty("line.separator");
		msg += "---------------------------" +getBckTree2().getBstname()+
				"---------------------------" + System.getProperty("line.separator");
		msg += getBckTree2().printBSTTree(
				getBckTree2().getRoot()) + System.getProperty("line.separator");
		Debug.println(4, msg);
		return msg;
	}

	/**
	 * Get the Sum of all three tree
	 */
	public void getSumOfAllTree(){
		Visitor bstvisitable = new BSTSumVisitor();
		Debug.println(2, "-------------------------Orignial Tree------------------------");
		Debug.println(5, "-------------------------Orignial Tree------------------------");
		getOriginalTree().getRoot().accept(bstvisitable);
		Debug.println(2, "-------------------------BackUp Tree1-------------------------");
		Debug.println(5, "-------------------------BackUp Tree1-------------------------");
		getBckTree1().getRoot().accept(bstvisitable);
		Debug.println(2, "-------------------------BackUp Tree2-------------------------");
		Debug.println(5, "-------------------------BackUp Tree2-------------------------");
		getBckTree2().getRoot().accept(bstvisitable);
	}
	
	/**
	 * Update the original tree
	 */
	public void updateTree(){
		getOriginalTree().updateNode(getOriginalTree().getRoot());
		Debug.println(3, printTree());
		Debug.println(5, printTree());
	}
	
	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BSTBuilder [br=" + br + ", filename=" + filename
				+ ", originalTree=" + originalTree + ", bckTree1=" + bckTree1
				+ ", bckTree2=" + bckTree2 + "]";
	}
	
}
