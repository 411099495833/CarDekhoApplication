package com.jspider.cardekhocasestudyapp.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsert {
   private static Connection connection;
   private static PreparedStatement preparedStatement;
   private static String query;
   
   public static void main(String[] args) {
	   
	   Scanner scanner=new Scanner(System.in);
	   System.out.println("Enter car id");
	   int id=scanner.nextInt();
	   scanner.nextLine();
	   System.out.println("Enter car name");
	   String name=scanner.nextLine();
	   System.out.println("Enter car Brand");
	   String brand=scanner.nextLine();
	   System.out.println("Enter car Fuel_type");
	   String fuel_type=scanner.nextLine();
	   System.out.println("Enter car price");
	   double price=scanner.nextDouble();
	   scanner.close();
	 try {
		openConnection();
		query="INSERT INTO car VALUES(?,?,?,?,?)";
		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
	    preparedStatement.setString(3, brand);	
	    preparedStatement.setString(4, fuel_type);
	    preparedStatement.setDouble(5, price);
	    int res=preparedStatement.executeUpdate();
	    System.out.println("data inserted");
		
		 
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	} finally {
		try {
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   }
   
   private static void openConnection() throws SQLException {
	   connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4","root","root");
   }
   
   private static void closeConnection() throws SQLException {
	   if(preparedStatement != null) {
		   preparedStatement.close();
	   }
	   if(connection != null) {
		   connection.close();
	   }
   }
}
