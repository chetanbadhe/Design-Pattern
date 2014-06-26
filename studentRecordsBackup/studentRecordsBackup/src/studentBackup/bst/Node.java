/**
 * Assignment 4
 * Backup System for Student Records
 * Programmer- Chetan Badhe
 */
package studentBackup.bst;

import java.util.ArrayList;

import studentBackup.util.Observer;
import studentBackup.util.Subject;
import studentBackup.util.Visitor;

/**
 * @author Chetan
 *
 */
public class Node implements Subject, Observer{
	
    private int val;         // associated data
    private Node left, right;  // left and right subtrees
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private int UPDATE_VAL = -1;
    
    public Node(int val) {
    	setVal(val);
    	setLeft(null);
    	setRight(null);
    }

	/**
	 * @return the val
	 */
	public int getVal() {
		return val;
	}

	/**
	 * @param val the val to set
	 */
	public void setVal(int val) {
		this.val = val;
	}

	/**
	 * @return the left
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 * @return the observers
	 */
	public ArrayList<Observer> getObservers() {
		return observers;
	}

	/**
	 * @param observers the observers to set
	 */
	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
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

	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		getObservers().add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
		getObservers().remove(observer);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(Observer ob: getObservers()){
			ob.update(this.getUPDATE_VAL());
		}
	}

	@Override
	public void update(int newValue) {
		// TODO Auto-generated method stub
		this.setUPDATE_VAL(newValue);
		this.setVal(this.getVal() + newValue);
		notifyObservers();
	}
	
	/**
	 * Accept method for Visitor
	 */
	public void accept(Visitor visitor){
		visitor.visit(this);
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [val=" + val + ", left=" + left + ", right=" + right
				+ ", observers=" + observers + ", UPDATE_VAL=" + UPDATE_VAL
				+ "]";
	}
}