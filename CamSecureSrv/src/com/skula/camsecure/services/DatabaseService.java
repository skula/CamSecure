package com.skula.camsecure.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseService {
	private Connection connection;

	public DatabaseService() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection("jdbc:mysql://192.168.1.62:3306/camsecure", "root", "root");
	}

	public boolean isAuthentified(String login, String passwd) {
		String query = "select count(*) count from users where login='" + login + "' and password='" + passwd + "'";
		int res = 0;
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				res = rs.getInt("count");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
		}
		return res == 1;
	}
}
