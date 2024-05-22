package application;
import java.util.ArrayList;

public interface VihicalRentInt {

	public abstract void addCustomer(String name,String address,String plan);
	public abstract void addCar(String name, String type,int noOfCarAvailable,String rating, int numberofpassengers);
	public abstract void addTruck(String name,String type,double weight,double load, int noOfavailableTruck );
	public abstract void addBus(String name, String type, int noOfavailableBus,int capacity);
	public abstract void setLimitedPlanLimit(int value);
	public abstract void getAllCustomersInfo();
	public abstract String getAllVehicleInfo();
	public abstract boolean addToCart(String customerName,String vehicle_name);
	public abstract boolean removeFromCart(String customerName, String vehicleName );
	public abstract String processRequests();
	public abstract boolean returnVehicle(String customerName,String vehicleName);
	public abstract ArrayList<String> searchVehicle(String name, String type,String rating);
	public abstract String deleteCustomer(String name);
	public abstract String SearchCustomer(String name);


}
