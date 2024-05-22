package application;

public class Car extends Vehicle{
	
	private String rating;
	private int numberofpassengers;

	
	public Car(String name, String type, int noOfVechiacleAvailable) {
		super(name, type, noOfVechiacleAvailable);
	}
	public Car() {
		
	}



	public Car(String name, String type, int noOfVechiacleAvailable, String rating, int numberofpassengers) {
		super(name, type, noOfVechiacleAvailable);
		this.rating = rating;
		this.numberofpassengers = numberofpassengers;
	}
	
	


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getNumberofpassengers() {
		return numberofpassengers;
	}


	public void setNumberofpassengers(int numberofpassengers) {
		this.numberofpassengers = numberofpassengers;
	}

	@Override
	public String toString() {
		return "Car ["+ super.toString() + "rating=" + rating + ", numberofpassengers=" + numberofpassengers + "]";
	}

	
}
