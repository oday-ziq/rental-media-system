package application;
import java.util.ArrayList;
import java.util.Collections;

public class RentVihicleSystem implements VihicalRentInt{
	
	ArrayList<Vehicle>V;
	ArrayList<Customer>C;
	int planLimt=2;
	
	

	public RentVihicleSystem()  {
		V=new ArrayList<Vehicle>();
		C=new ArrayList<Customer>();
	}
	
	public ArrayList<Vehicle> getV() {
		return V;
	}

	public ArrayList<Customer> getC() {
		return C;
	}


	@Override
	public void addCustomer(String name, String address, String plan) {
		C.add(new Customer(name,address,plan));
		
	}

	@Override
	public void addCar(String name, String type, int noOfCarAvailable, String rating, int numberofpassengers) {
		V.add(new Car(name,type,noOfCarAvailable,rating,numberofpassengers));
		
	}

	@Override
	public void addTruck(String name, String type, double weight, double load, int noOfavailableTruck) {
		V.add(new Truck(name,type,weight,load,noOfavailableTruck));
		
	}

	@Override
	public void addBus(String name, String type, int noOfavailableBus, int capacity) {
		V.add(new Bus(name,type,noOfavailableBus,capacity));
		
	}

	@Override
	public void setLimitedPlanLimit(int value) {
		planLimt = value;
	}

	@Override
	public void getAllCustomersInfo() {
		Collections.sort(C);
		for (int i = 0; i < C.size(); i++) {
			System.out.println(C.get(i).toString()+"\n");
		}
	}

	@Override
	public String getAllVehicleInfo() {
		Collections.sort(V);
		for (int i = 0; i < V.size(); i++) {
			System.out.println(V.get(i).toString()+"\n");
		}
		return null;
	}

	@Override
	public boolean addToCart(String customerName, String vehicle_name) {
		for(int i=0;i<C.size();i++) {//read all customer
			for(int j=0;j<V.size();j++) {//read all media
				if(C.get(i).getName().equalsIgnoreCase(customerName) && V.get(j).getName().equalsIgnoreCase(vehicle_name)) {
					boolean a=C.get(i).getIntrested().contains(V.get(j));
					if(a==false) {
						C.get(i).getIntrested().add(V.get(j));
						return true;
					}
				else if(a==true)
					return false;
				}
			}
		}
			
		return false;
	}

	@Override
	public boolean removeFromCart(String customerName, String vehicleName) {
		for(int i=0;i<C.size();i++) {
			if(C.get(i).getName().equalsIgnoreCase(customerName)) {
				for(int j=0;j<V.size();j++) {
					if(V.get(j).getName().equalsIgnoreCase(vehicleName)) {
						boolean a=C.get(i).getIntrested().contains(V.get(j));
						if(a==false) 
							return false;
						else if(a==true) {
							C.get(i).getIntrested().remove(V.get(j));
							return true;
						}
					}
				}
			}
			else
				return false;
		}	
		return false;
	}

	@Override
	public String processRequests() {
		Collections.sort(C);
		String cName;
		String vName;
		for (int i = 0; i < C.size(); i++) {
			for (int j = 0; j < C.get(i).getIntrested().size(); j++) {
				if(C.get(i).getPlane().equalsIgnoreCase("limited") && C.get(i).getRented().size()<=planLimt){
					C.get(i).getRented().add(V.get(j));
					C.get(i).getIntrested().remove(V.get(j));
					int num = V.get(i).getNoOfVechiacleAvailable();
					V.get(i).setNoOfVechiacleAvailable(--num);
					System.out.println(C.get(i).getName() +"rented"+ V.get(i).getName());
				}
				else if (C.get(i).getPlane().equalsIgnoreCase("unlimited")) {
					C.get(i).getRented().add(V.get(j));
					C.get(i).getIntrested().remove(V.get(j));
					int num = V.get(i).getNoOfVechiacleAvailable();
					V.get(i).setNoOfVechiacleAvailable(--num);
					System.out.println(C.get(i).getName() +"rented"+ V.get(i).getName());
				}
				
				else
					System.out.println("you reach the maximum size of vihecle for your plan");
			}
		}
		
		return null;
	}

	@Override
	public boolean returnVehicle(String customerName, String vehicleName) {
		for (int i = 0; i < C.size(); i++) {
			for (int j = 0; j < C.get(i).getRented().size(); j++) {
				if(C.get(i).getRented().contains(vehicleName)) {
					C.get(i).getRented().remove(V.get(j));
					int num = V.get(i).getNoOfVechiacleAvailable();
					V.get(i).setNoOfVechiacleAvailable(++num);
				}
				else {
					System.out.println("the vehicle is not rented to this customer");
				}
			}
		}
		return false;
	}
	
	@Override
	public String deleteCustomer(String name) {
		for(int i=0;i<C.size();i++) {
			if(C.get(i).getName().equals(name)) {
				String s ="Deleted Customer " + C.get(i).toString();
				C.remove(i);
				return s;
			}
		}
		return "Customer not found";
	}
	
	@Override
	public String SearchCustomer(String name) {
		for(int i=0;i<C.size();i++) {
			if(C.get(i).getName().equals(name)) {
				String s = C.get(i).toString();
				return s;
			}
		}
		return "Customer not found";
	}

	@Override
	public ArrayList<String> searchVehicle(String name, String type, String rating) {
		if(name== null &&type==null && rating == null) {
			 for (int i = 0; i < V.size(); i++) {
				System.out.println(V.get(i).getName());
			}
		}
		else if (type==null && rating == null) {
			for (int i = 0; i < V.size(); i++) {
				if(V.get(i).getName().equalsIgnoreCase(name)) {
					System.out.println(V.get(i).getName());
				}
			}
		}
		else if(name== null && rating == null) {
			for (int i = 0; i < V.size(); i++) {
				if(V.get(i).getType().equalsIgnoreCase(type)) {
					System.out.println(V.get(i).getName());
				}
			}
		}
		else if(name== null && type == null) {
			for (int i = 0; i < V.size(); i++) {
				if(V.get(i) instanceof Car && ((Car) V.get(i)).getRating().equalsIgnoreCase(rating)) {
					System.out.println(V.get(i).getName());
				}
			}
		}
		else if(rating== null) {
			for (int i = 0; i < V.size(); i++) {
				if(V.get(i).getName().equalsIgnoreCase(name) && V.get(i).getType().equalsIgnoreCase(type)) {
					System.out.println(V.get(i).getName());
				}
			}
		}
		else if(name== null) {
			for (int i = 0; i < V.size(); i++) {
				if(V.get(i) instanceof Car && ((Car) V.get(i)).getRating().equalsIgnoreCase(rating) && V.get(i).getType().equalsIgnoreCase(type)) {
					System.out.println(V.get(i).getName());
				}
			}
		}
		else if(type== null) {
			for (int i = 0; i < V.size(); i++) {
				if(V.get(i) instanceof Car && ((Car) V.get(i)).getRating().equalsIgnoreCase(rating) && V.get(i).getName().equalsIgnoreCase(name)) {
					System.out.println(V.get(i).getName());
				}
			}
		}
		else {
			for (int i = 0; i < V.size(); i++) {
				if(V.get(i) instanceof Car && ((Car) V.get(i)).getRating().equalsIgnoreCase(rating) && V.get(i).getName().equalsIgnoreCase(name) &&  V.get(i).getType().equalsIgnoreCase(type)) {
					System.out.println(V.get(i).getName());
				}
			}
		}
		
		return null;
	}


}