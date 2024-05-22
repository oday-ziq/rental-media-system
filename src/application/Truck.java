package application;

public class Truck extends Vehicle{
	
	private double weight;
	private double load;
	
	public Truck(String name, String type, double weight, double load, int noOfVechiacleAvailable) {
		super(name, type, noOfVechiacleAvailable);
		this.weight = weight;
		this.load = load;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getLoad() {
		return load;
	}
	
	public void setLoad(double load) {
		this.load = load;
	}

	@Override
	public String toString() {
		return "Truck ["+ super.toString() + "weight=" + weight + ", load=" + load + "]";
	}

}
