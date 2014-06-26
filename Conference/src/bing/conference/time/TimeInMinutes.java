package bing.conference.time;

public class TimeInMinutes implements TimeInterface {

	private int timeValue;
	
	@Override
	public String getTimeType() {
		// TODO Auto-generated method stub
		return "minutes";
	}
	public int getTimeValue() {
		return timeValue;
	}
	public void setTimeValue(int timeValue) {
		this.timeValue = timeValue;
	}
	@Override
	public void setTime(int time) {
		// TODO Auto-generated method stub
		timeValue = time;
	}
	@Override
	public Object getTimeObject() {
		// TODO Auto-generated method stub
		return this;
	}

	
	
}
