package application;

public abstract class Vehicle implements Comparable<Vehicle>{

	private String name;
	private String type;
	private int noOfVechiacleAvailable;
	public Vehicle(String name, String type, int noOfVechiacleAvailable) {
		super();
		this.name = name;
		this.type = type;
		this.noOfVechiacleAvailable = noOfVechiacleAvailable;
	}
	public Vehicle() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNoOfVechiacleAvailable() {
		return noOfVechiacleAvailable;
	}
	public void setNoOfVechiacleAvailable(int noOfVechiacleAvailable) {
		this.noOfVechiacleAvailable = noOfVechiacleAvailable;
	}
	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", type=" + type + ", noOfVechiacleAvailable=" + noOfVechiacleAvailable + "]";
	}
	public int compareTo(Vehicle v){
		if(this.name.compareTo(v.name)>0)
			return 1;
		else if(this.name.compareTo(v.name)<0)
			return -1;
		else
			return 0;
	}
	
	
}
