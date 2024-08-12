package com.comcast.crm.generic.databaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DBUtility {

	Connection conn=null;

	public void getDbConnection(String url, String username,String password) throws SQLException {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);

			conn = DriverManager.getConnection(url,username,password);
		}catch (Exception e) {

		}
	}
	
	public void getDbConnection() throws SQLException {
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);

			conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
		}catch (Exception e) {

		}
	}

	public void closeDbConnection() throws SQLException {
		try {
			conn.close();
		}catch (Exception e) {
		}
	}

	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result=null;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeQuery(query);
		}catch (Exception e) {
		}
		return result;
	}

	public int executeNonSelectQuery(String query) throws SQLException {
		int result = 0;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeUpdate(query);
		}catch (Exception e) {
		}
		return result;

	}
}
