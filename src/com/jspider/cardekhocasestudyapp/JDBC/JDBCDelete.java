package com.jspider.cardekhocasestudyapp.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCDelete {
   private static Connection connection;
   private static PreparedStatement preparedStatement;
   private static String query;
   
   public static void main(String[] args) {
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
