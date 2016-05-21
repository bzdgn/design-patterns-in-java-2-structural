package structural.facade.jdbcwithfacade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import structural.facade.repo.DbSingleton;

public class JdbcFacade {
	
	DbSingleton instance = null;
	
	public JdbcFacade() {
		this.instance = DbSingleton.getInstance();
	}
	
	public int createTable() {
		int count = 0;
		
		try {
			Connection conn = instance.getConnection();
			Statement sta = conn.createStatement();
			
			count = sta.executeUpdate(
				"CREATE TABLE Address (ID INTEGER, StreetName VARCHAR(20), City VARCHAR(20))"
			);
			
			sta.close();
//			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int insertIntoTable() {
		int count = 0;
		
		try {
			Connection conn = instance.getConnection();
			Statement sta = conn.createStatement();
			
			count = sta.executeUpdate(
					"INSERT INTO Address(ID, StreetName, City) " + 
					"values(1, '1234 Some street', 'Istanbul')"
				);
				
			sta.close();
//			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public List<Address> getAddreses() {
		List<Address> addresses = new LinkedList<>();
		
		try {
			Connection conn = instance.getConnection();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("SELECT * FROM Address");
			
			while(rs.next())
				addresses.add(new Address(rs.getInt(1), rs.getString(2), rs.getString(3)));
			
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return addresses;
	}
	
}
