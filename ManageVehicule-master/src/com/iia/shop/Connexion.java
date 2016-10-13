package com.iia.shop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

	
	private static final String URL = "jdbc:sqlserver://B17-14;databaseName=Store;";
	private static final String PASSWORD = "SQL2014";
	private static final String LOGIN = "sa";
	
	
	public static Connection getConnection() {
		
		Connection connection = null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			connection = DriverManager.getConnection(Connexion.URL, Connexion.LOGIN, Connexion.PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
		
}
