package com.example.jdbc_mysql_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String URL = System.getenv("DB_URL");
	private static final String USERNAME = System.getenv("DB_USERNAME");
	private static final String PASSWORD = System.getenv("DB_PASSWORD");

	public static Connection getConnection() throws SQLException {

		if (URL == null || USERNAME == null || PASSWORD == null) {
			throw new SQLException("Database environment variables are not set");
		}

		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}
