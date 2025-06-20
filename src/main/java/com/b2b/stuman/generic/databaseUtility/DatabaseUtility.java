package com.b2b.stuman.generic.databaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtility {
	Connection connection;
	
	public void getConnect(String url,String username,String password)
	{
		try {
			connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Connection failed");
		}
	}
	public ResultSet executeSelectQuery(String query)
	{
		ResultSet resultSet = null;
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public int executeNonSelectQuery(String query) 
	{
		int updatedRows= 0;
		try {
			Statement statement = connection.createStatement();
			updatedRows = statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updatedRows;
	}
	
	public void closeConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
