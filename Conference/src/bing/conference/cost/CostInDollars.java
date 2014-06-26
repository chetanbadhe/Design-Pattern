package bing.conference.cost;

public class CostInDollars implements CostInterface {

	private double costValue;
	
	
	@Override
	public String getCostType() {
		// TODO Auto-generated method stub
		return "Dollar";
	}


	public double getCostValue() {
		return costValue;
	}


	public void setCostValue(double costValue) {
		this.costValue = costValue;
	}


	@Override
	public void setCost(double cost) {
		// TODO Auto-generated method stub
		this.costValue = cost;
	}


	@Override
	public Object getCostObject() {
		// TODO Auto-generated method stub
		return this;
	}
	
	

}
