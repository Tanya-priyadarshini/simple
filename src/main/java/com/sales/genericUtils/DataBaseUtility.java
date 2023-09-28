package com.sales.genericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con=null;
	/**
	 * This method is used to connect the Database
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathconstants.dburl,IPathconstants.dbusername,IPathconstants.dbpassword);
	}
	/**
	 * This method is use to execute the query and get the data
	 * @param query
	 * @param coloumnno
	 * @param expdata
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndGetData(String query,int coloumnno,String expdata) throws SQLException {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next()) {
			String data = result.getString(coloumnno);
			if(data.equalsIgnoreCase(expdata)) {
				flag=true;
				break;
			}
		}
		if(flag==true) {
			System.out.println("Data is verified");
			return expdata;
		}
		else {
			System.out.println("Data is not present");
			return "";
		}
	
	}
	/**
	 * This method is use to close the Database connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		con.close();
	}

}
