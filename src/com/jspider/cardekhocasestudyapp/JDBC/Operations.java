package com.jspider.cardekhocasestudyapp.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Operations {

	private static PreparedStatement preparedStatement;
	private static Connection connection;
	private static String query;
	private static ResultSet resultSet;
	
	public void carDelete() {
		 Scanner scanner=new Scanner(System.in);
		   System.out.println("Enter car id");
		   int id=scanner.nextInt();
		   scanner.nextLine();
		   scanner.close();
		try {
			openConnection();
			query="DELETE from car WHERE id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int res=preparedStatement.executeUpdate();
			if(res==1) {
				System.out.println("car details deleted successfully");
			}else {
				System.out.println("car not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	   }
	public void addCar() {
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
	public void searchCar() {
		Scanner scanner=new Scanner(System.in);
		  System.out.println("Enter the car id");
		  int id=scanner.nextInt();
		try {
			openConnection();
			query="SELECT * FROM car WHERE id=?";
			
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
				System.out.println(resultSet.getDouble(5));
			}else {
				System.out.println("car not found");
			}
			
		  
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
		public void updateCar() throws SQLException {
			 Scanner scanner=new Scanner(System.in);
			 System.out.println("Enter car id");
			 int id=scanner.nextInt();
			 scanner.nextLine();
			 System.out.println("Enter car name");
			 String name=scanner.nextLine();
			 System.out.println("Enter car brand");
			 String brand=scanner.nextLine();
			 System.out.println("Enter car fuel_type");
			 String fuel_type=scanner.nextLine();
			 System.out.println("Enter car price");
			 Double price=scanner.nextDouble();
			 scanner.nextLine();
			 scanner.close();
			try {
				openConnection();
				query="UPDATE car SET name=?,brand=?,fuel_type=?,price=? WHERE id=?";
				preparedStatement=connection.prepareStatement(query);
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, brand);
				preparedStatement.setString(3, fuel_type);
				preparedStatement.setDouble(4, price);
				preparedStatement.setInt(5, id);
				int res=preparedStatement.executeUpdate();
				if(res==1) {
					System.out.println(res + "data updated");
				}
				else {
					System.out.println("car not found");
				}
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
			  if(connection != null) {
				  connection.close();
			  }
			  if(preparedStatement != null) {
				  preparedStatement.close();
			  }
		  }

	
	}

