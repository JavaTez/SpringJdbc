package com.sun.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	
	private static final String URL= "jdbc:mysql://127.0.0.1:3306/world";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";
	private static final String QUERY = "select * from city";
	
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		Statement st = null;
		try {
			con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			st = con.createStatement();
			ResultSet rs = st.executeQuery(QUERY);
			if(null != rs){
				System.out.println("Name      CountryCode     District   Population");
				System.out.println("================================================");
				while(rs.next()){
					
					System.out.print(rs.getString("Name")+"     ");
					System.out.print(rs.getString("CountryCode")+"     ");
					System.out.print(rs.getString("District")+"     ");
					System.out.print(rs.getString("Population")+"     ");
					System.out.println(); 
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(null != st){
				st.close();
			}
			if(null != con){
				con.close();
			}
		}
	}
	
	

}
