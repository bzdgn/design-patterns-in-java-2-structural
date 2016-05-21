package structural.facade.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {
	
	private static DbSingleton instance = null;	// Lazy Loading
	private Connection conn = null;
	
	private DbSingleton() {
		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static DbSingleton getInstance() {
		if(instance == null) {
			synchronized(DbSingleton.class) {
				if(instance == null) {
					instance = new DbSingleton();	// Lazy Loading
				}
			}
		}
		
		return instance;
	}
	
	public Connection getConnection() {
		if(conn == null) {
			synchronized(DbSingleton.class) {
				if(conn == null) {
					try {
						//String dbUrl = "jdbc:derby:memory:levoDB/singletonDemo;create=true";
						String dbUrl = "jdbc:derby://localhost:1527/memory:levoDB/singletonDemo;create=true";
						
						conn = DriverManager.getConnection(dbUrl);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return conn;
	}
	
}
