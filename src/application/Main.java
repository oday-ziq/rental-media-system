package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	RentVihicleSystem rvs = new RentVihicleSystem();
	
	Scene scene1,addScene,deleteScene,SearchScene,carScene,busScene,truckScene;
	@Override
	public void start(Stage primaryStage) {
		try {
			File veh = new File("prevDataMedia.txt");
		      Scanner myReader1 = new Scanner(veh);
		      while (myReader1.hasNextLine()) {
		        String data = myReader1.nextLine();
		        String[] s1 = data.split(" ");
		        
		        String type = s1[1];
		        if(type.equalsIgnoreCase("car")) {
		        	String name = s1[0];
		        	String type1 = s1[1];
		        	int noCar = Integer.parseInt(s1[2]);
		        	String rating = s1[3];
		        	int nomOfPas = Integer.parseInt(s1[4]);
		        	RentVihicleSystem c = new RentVihicleSystem();
			        c.addCar(name, type1, noCar, rating, nomOfPas);
		        }
		        else if(type.equalsIgnoreCase("bus")) {
		        	String name = s1[0];
		        	String type1 = s1[1];
		        	int noBus = Integer.parseInt(s1[2]);
		        	int capacity = Integer.parseInt(s1[3]);
		        	RentVihicleSystem b = new RentVihicleSystem();
		        	b.addBus(name, type1, noBus, capacity);
		        }
		        else if(type.equalsIgnoreCase("truck")) {
		        	String name = s1[0];
		        	String type1 = s1[1];
		        	double weight = Double.parseDouble(s1[2]);
		        	double load = Double.parseDouble(s1[3]);
		        	int noCar = Integer.parseInt(s1[4]);
		        	RentVihicleSystem t = new RentVihicleSystem();
		        	t.addTruck(name, type1, weight, load, noCar);
		        }

		        //System.out.println(data);
		      }
		      
		      myReader1.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		try {
			ArrayList<String> intrested = new ArrayList<String>();
			File cus = new File("prevDataCustomers.txt");
		      Scanner myReader = new Scanner(cus);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] s1 = data.split(" ");
		        String name = s1[0];
		        String address = s1[1];
		        String plan = s1[2];
		        
		        
		        rvs.addCustomer(name, address,plan);
		      }
		      
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		try {
		      
			VBox v = new VBox(10);
			Button customer = new Button("Customer");
			
			v.setAlignment(Pos.CENTER);
			v.getChildren().addAll(customer);
			Scene scene = new Scene(v,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			customer.setOnAction(e->{
				scene1 = scene(primaryStage);
				primaryStage.setScene(scene1);
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private Scene scene(Stage primaryStage) {
		VBox v = new VBox(10);
		Button add = new Button("Add Customer");
		Button search = new Button("Search Customer");
		Button delete = new Button("Delete Customer");
		Button Report = new Button("Report to file");
		v.setAlignment(Pos.CENTER);
		v.getChildren().addAll(add,search,delete,Report);
		add.setOnAction(e->{
			addScene = scene2(primaryStage);
			primaryStage.setScene(addScene);
		});
		
		delete.setOnAction(e->{
			deleteScene = scene3(primaryStage);
			primaryStage.setScene(deleteScene);
		});
		
		search.setOnAction(e->{
			SearchScene = scene4(primaryStage);
			primaryStage.setScene(SearchScene);
		});
		
		Report.setOnAction(e->{
			FileWriter fileWriter;
			try {
				fileWriter = new FileWriter("prevDataCustomers.txt");
				PrintWriter printWriter = new PrintWriter(fileWriter);
				for(int i = 0; i < rvs.getC().size(); i++) {
					printWriter.print(rvs.C.get(i).toString());
				}
			    
			    printWriter.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		return scene1= new Scene(v,400,400);
	}
	
	
	private Scene scene2(Stage primaryStage) {
		VBox v = new VBox(10);
		
		VBox v2 = new VBox(10);
		HBox h = new HBox();
		HBox h1 = new HBox();
		HBox h2 = new HBox();
		HBox h3 = new HBox();
		HBox h4 = new HBox();
		
		Label Name = new Label     ("Customer Name                   ");
		TextField tf1 = new TextField();
		h.getChildren().addAll(Name,tf1);
		
		Label Address = new Label     ("Address                   ");
		TextField tf2 = new TextField();
		h1.getChildren().addAll(Address,tf2);
		
		Label plan = new Label   ("plan                     ");
		TextField tf3 = new TextField();
		h3.getChildren().addAll(plan,tf3);
		
		Button AddCus = new Button("Add");
		AddCus.setOnAction(e->{
			rvs.addCustomer(tf1.getText(), tf2.getText(), tf3.getText());
			rvs.getAllCustomersInfo();
			tf1.clear();
			tf2.clear();
			tf3.clear();
		});
		Button back = new Button("back");
		v.setPadding(new Insets(10));
		v.getChildren().addAll(h,h1,h2,h3,h4,AddCus,back);
		 addBinding(AddCus, tf1, tf2, tf3);
		back.setOnAction(e->{
			primaryStage.setScene(scene1);
		});
		
		return addScene= new Scene(v,400,400);
	} 
	
	private Scene scene3(Stage primaryStage) {
		VBox v = new VBox(10);
		HBox h = new HBox();
		
		
		Label Name = new Label     ("Custmer Name                   ");
		TextField Tname = new TextField();
		h.getChildren().addAll(Name,Tname);
		
		Label L = new Label();
		
		Button Delete = new Button("Delete Custmer");
		
		Delete.setOnAction(e->{
			String a = rvs.deleteCustomer(Tname.getText());
			L.setText(a);
			rvs.getAllCustomersInfo();
			Tname.clear();
		});
		Button back = new Button("Back");
		back.setOnAction(e->{
			primaryStage.setScene(scene1);
		});
		
		v.getChildren().addAll(h,Delete,L,back);
		
		return carScene= new Scene(v,400,400);
	} 
	
	private Scene scene4(Stage primaryStage) {
		VBox v = new VBox(10);
		HBox h = new HBox();
		Label L = new Label("");
		
		Label Name = new Label     ("Custmer Name                   ");
		TextField Tname = new TextField();
		h.getChildren().addAll(Name,Tname);
		
		Button Search = new Button("Search Custmer");
		
		Search.setOnAction(e->{
			String a = rvs.SearchCustomer(Tname.getText());
			L.setText(a);
			Tname.clear();
		});
		Button back = new Button("Back");
		back.setOnAction(e->{
			primaryStage.setScene(scene1);
		});
		
		v.getChildren().addAll(h,Search,L,back);
		
		return SearchScene= new Scene(v,400,400);
	} 
	
	
	private void addBinding(Button AddCus, TextField... textFields) {
        for (int i = 0; i < textFields.length; i++) {
            TextField tf = textFields[i];
            Node node = i == textFields.length - 1 ? AddCus : textFields[i + 1];
            node.disableProperty().bind(
                    Bindings.createBooleanBinding(() -> tf.isDisable() || tf.getText() == null || tf.getText().isEmpty(),
                            tf.textProperty(), tf.disableProperty()));
        }
    }
	
	
	
	
	
	
	
	
	
}
