package application;
import java.util.ArrayList;

public class Customer implements Comparable<Customer>{
	
	private String name;
	private String address;
	private String plane;
	private ArrayList<Vehicle>Intrested;
	private ArrayList<Vehicle>Rented;
	
	
	public Customer(String name, String address, String plane) {
		super();
		this.name = name;
		this.address = address;
		this.plane = plane;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getPlane() {
		return plane;
	}


	public void setPlane(String plane) {
		this.plane = plane;
	}

	public ArrayList<Vehicle> getIntrested() {
		return Intrested;
	}

	public void setIntrested(ArrayList<Vehicle> intrested) {
		Intrested = intrested;
	}

	public ArrayList<Vehicle> getRented() {
		return Rented;
	}

	public void setRented(ArrayList<Vehicle> rented) {
		Rented = rented;
	}
	
	

	@Override
	public String toString() {
		return  name + " " + address + " " + plane +"\n";
	}

	@Override
	public int compareTo(Customer o) {
		if(this.name.compareTo(o.name)>0)
			return 1;
		else if(this.name.compareTo(o.name)<0)
			return -1;
		else
		return 0;
	}
	
	

}
