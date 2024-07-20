package com.jspider.cardekhocasestudyapp.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class JDBCUpdate {
  private static Connection connection;
  private static PreparedStatement preparedStatement;
  private static String query;
  
  public static void main(String[] args) throws SQLException {
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
