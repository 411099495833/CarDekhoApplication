package com.jspider.cardekhocasestudyapp.Operation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.List;

import com.jspider.cardekhocasestudyapp.entity.Car;
public class CarOperation {
   
	private static List<Car>cars=new ArrayList<>();
	
	//method for viewAllCars		
    public void viewAllcars() {
		System.out.println("===All cars===");
		for(Car car : cars) {
			System.out.println(car);
		}
	}
	
	
	//search byName()
	public void byName() {
		Scanner scanner3 =new Scanner(System.in);
		System.out.println("Enter car name ");
		String name=scanner3.next();
		
		for(Car car:cars) {
			if(car.getName().equals(name)) {
				System.out.println(car);
				
			}
		}
		
	}
	
	//search byBrand()
	public void byBrand() {
		Scanner scanner3 =new Scanner(System.in);
		
		System.out.println("Enter car brand ");
		String brand=scanner3.next();
		
		for(Car car:cars) {
			if(car.getBrand().equals(brand)) {
				System.out.println(car);
				
			}
		}
		
	}
	
	//search byFuelType()
	public void byFuelType() {
		Scanner scanner3 =new Scanner(System.in);
		System.out.println("Enter car FuelType ");
		String type=scanner3.next();
		
		for(Car car:cars) {
			if(car.getFuelType().equals(type)) {
				System.out.println(car);
				
			}
		}
		
	}
	//search byPrice()
	public void byPrice() {
		Scanner scanner4=new Scanner(System.in);
		
		System.out.println("Enter car price");
		double prices=scanner4.nextDouble();
		
		for(Car car:cars) {
			if(car.getPrice()==(prices)) {
				System.out.println(car);
				
			}
		}
		
	}
	
	//search byId()
	public void byId() {
		Scanner scanner4=new Scanner(System.in);
		System.out.println("Enter car id");
		int id=scanner4.nextInt();
		
		for(Car car:cars) {
			if(car.getId()==id) {
			System.out.println(car);
			}
		}
	}
	
	//removecar()
	public void removeCar() {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the id");
		boolean flag=false;
		int id=scanner.nextInt();
		
		for(Car car:cars) {
			if(car.getId()==(id)) {
				cars.remove(car);
				flag=true;
			}	
		
		}
		if(!flag){
			System.out.println("car not found");
		}
	}
	
	//edit()
	public void editCarDetails() {
		Scanner scanner=new Scanner(System.in);
		boolean flag=false;
		System.out.println("Enter car id");
		int id=scanner.nextInt();
		for(Car car:cars) {
			if(car.getId()== id) {
			System.out.println("Enter car name");
			car.setName(scanner.next());
			
			System.out.println("Enter car brand");
			car.setBrand(scanner.next());
			
			System.out.println("Enter car fueltype");
			car.setFuelType(scanner.next());
			
			System.out.println("Enter car price");
			car.setPrice(scanner.nextDouble());
			System.out.println("Edit car");
			flag=true;
			}
			
		}
		if(!flag){
			System.out.println("car not found");
		}
	}
	 
	
	//addcar()
   public void addcar() {
	   Scanner scanner=new Scanner(System.in);
	   
	   Car car=new Car();
	   
	   System.out.println("Enter car id:");
       car.setId(scanner.nextInt());

       System.out.println("Enter car name:");
       car.setName(scanner.next());

       System.out.println("Enter car brand:");
       car.setBrand(scanner.next());

       System.out.println("Enter car fuel type:");
       car.setFuelType(scanner.next());

       System.out.println("Enter car price:");
       car.setPrice(scanner.nextDouble());

       cars.add(car);
       System.out.println("Car added successfully!");
   }

   }
   
    

