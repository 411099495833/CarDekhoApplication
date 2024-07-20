package com.jspider.cardekhocasestudyapp.Menu;

import java.util.Scanner;

import com.jspider.cardekhocasestudyapp.Operation.CarOperation;

public class CarDekhoMenu {
	

	static boolean loop=true;
	
	public static void mainMenu() {
    CarOperation caroperation=new CarOperation();
    
    System.out.println("======MainMenu======\n"
    		 + "1. View all cars\n"
    		 + "2. Search cars\n"
    		 + "3. Add cars\n"
    		 + "4. Remove cars\n"
    		 + "5. Edit cars\n"
    		 + "6. Exit");
    
    Scanner scanner =new Scanner(System.in);
    int choice=scanner.nextInt();
    
    switch(choice) {
    case 1:
    	System.out.println("View all cars");
    	caroperation.viewAllcars();
    	break;
    	
    case 2:
    	System.out.println("======Search car======\n"
    			+ "1.Search by name\n"
    			+ "2.Search by brand\n"
    			+ "3.Search by fueltype\n"
    			+ "4.Search by price\n"
    			+ "5.Search by id\n"
    			+ "6.go back");
    	Scanner scanner1=new Scanner(System.in);
    	int choice1=scanner1.nextInt();
    	
    	switch(choice1) {
    	
    	case 1:
    		caroperation.byName();
    	break;
    	
    	case 2:
    		caroperation.byBrand();
    	break;
    	
    	case 3:
    		caroperation.byFuelType();
    	break;
    	case 4:
    		caroperation.byPrice();
    	break;
    	case 5:
    		caroperation.byId();
    	break;
    	case 6:
    		 mainMenu();
    	break;
    	default:
    		System.out.println("Exit");
    		loop=false;
    		break;
    	}
    	break;
    	
    	
    case 3:
    	caroperation.addcar();
    	System.out.println("Add car");
    	break;
    
    case 4:
    	caroperation.removeCar();
    	System.out.println("Remove car");
    	break;
    	
    case 5:
    	caroperation.editCarDetails();
    	System.out.println("car details are edited");
    	break;
    
    case 6:
    	System.out.println("thank you");
    	break;
    
    default :
    	System.out.println("Invalid number");
    	break;
    }
    
}
	
	public static void main(String[] args) {
		while(loop) {
			mainMenu();
		}
	}
}
