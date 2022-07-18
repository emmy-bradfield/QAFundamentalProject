package com.qa.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SQLConnector {

	static Logger LOGGER = LogManager.getLogger();

	// Attributes
	String localhost;
	String user;
	String password;
	SQLConnector connector;

	// Constructor
	public SQLConnector(String user, String password) {
		this.localhost = "jdbc:mysql://localhost:3306/storeDB";
		this.user = user;
		this.password = password;
	}

	public Connection connectDB() {
		Connection useDB = null;
		try {
			useDB = DriverManager.getConnection(localhost, user, password);
			System.out.println("Connected successfully");
		} catch (SQLException e) {
			LOGGER.debug("Unable to connect");
			LOGGER.debug(e.getStackTrace());
			e.printStackTrace();
		}
		return useDB;
	}

}