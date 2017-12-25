package com.trendyolConf.spring.library;

import java.sql.*;
import java.util.HashMap;

public class DBConnection {
	private HashMap<String, Config> configurationValues = new HashMap<String, Config>();
	private Connection conn;
	private String applicationName;
	public DBConnection(String connectionString, String applicationName) {
		Connect(connectionString);
		this.applicationName=applicationName;
	}
	public void Connect(String connectionString){
		try {
			conn = DriverManager.getConnection(connectionString, "root", "155991ath");
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());

		}
	}

	public HashMap<String, Config> getValueConf() {
		try {
			// String myUrl = "jdbc:mysql://localhost/trendyolcase";

			// our SQL SELECT query.
			// if you only need a few columns, specify them by name instead of using "*"
			//String query = "SELECT * FROM configstorage where isactive = 1";
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM configstorage where isactive = 1 and applicationname = ?");    
			statement.setString(1, applicationName);
			// create the java statement
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset
			//ResultSet rs = st.executeQuery(statement);
			ResultSet rs = statement.executeQuery();
			// iterate through the java resultset
			while (rs.next()) {
				configurationValues.put(rs.getString("name"), new Config(rs.getString("type"), rs.getString("value")));
			}

			st.close();
			return configurationValues;
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
			return null;
		}

	}
}
