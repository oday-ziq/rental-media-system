package application;

public class Bus extends Vehicle{

	private int capacity;

	public Bus(String name, String type, int noOfVechiacleAvailable, int capacity) {
		super(name, type, noOfVechiacleAvailable);
		this.capacity = capacity;
	}



	public int getCapacity() {
		return capacity;
	}



	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Bus ["+ super.toString() + "capacity=" + capacity + " ]";
	}
}
