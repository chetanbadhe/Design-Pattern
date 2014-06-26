package bing.conference.carbon;

public class CarbonInTonnes implements CarbonInterface {

	private double carbonValue;

	public double getCarbonValue() {
		return carbonValue;
	}



	public void setCarbonValue(double carbonValue) {
		this.carbonValue = carbonValue;
	}



	@Override
	public String getCarbonType() {
		// TODO Auto-generated method stub
		return "Tonnes";
	}

	

	@Override
	public void setCarbon(double carbon) {
		// TODO Auto-generated method stub
		carbonValue = carbon;
	}



	@Override
	public Object getCarbonObject() {
		// TODO Auto-generated method stub
		return this;
	}

}
