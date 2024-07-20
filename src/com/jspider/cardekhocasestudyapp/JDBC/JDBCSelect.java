package com.jspider.cardekhocasestudyapp.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCSelect {
  private static Connection connection;
  private static PreparedStatement preparedStatement;
  private static ResultSet resultSet;
  private static String query;
  
  public static void main(String[] args) {
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
	   if(resultSet != null) {
		   resultSet.close();
	   }
  }
  }

