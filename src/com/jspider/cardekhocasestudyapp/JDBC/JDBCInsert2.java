package com.jspider.cardekhocasestudyapp.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsert2 {
 private static Connection connection;
 private static PreparedStatement preparedStatement;
 private static String query;
 
 public static void main(String[] args) throws SQLException {
	 try {
		 openConnection();
		 query="INSERT INTO car VALUES(?,?,?,?,?)";
		 preparedStatement=connection.prepareStatement(query);
		 System.out.println("How many data you want to insert?");
		 Scanner scanner=new Scanner(System.in);
		 int count=scanner.nextInt();
		 for(int i=1; i<=count; i++) {
			System.out.println("Enter user id");
			int id=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter car name");
			String name=scanner.nextLine();
			System.out.println("Enter car brand");
			String brand=scanner.nextLine();
			System.out.println("Enter car fuel_type");
			String fuel_type=scanner.nextLine();
			System.out.println("Enter car price");
			double price=scanner.nextDouble();
			
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, brand);
			preparedStatement.setString(4, fuel_type);
			preparedStatement.setDouble(5, price);
			preparedStatement.addBatch();	
		 }
		 int[] res=preparedStatement.executeBatch();
		 System.out.println("Data inserted successfully");

		
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	} finally {
		closeConnection();
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
