package com.fdmgroup;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCApp {
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USERNAME = "trainee1";
	private static final String DB_PASSWORD = "!QAZSE4";

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		// createTable();
		// insertData();
		// retreiveData();
		// retreiveDataUsingExecute();
		// retrieveDataUsingFilter(1);
		// retrieveDataUsingPreparedStatement(1,"jdoe");
		// testBatchInsert();
		// testCallableStatement();
		//testUpdatableResultSet();
		getDataBaseMetaData();
	}

private static void getDataBaseMetaData() {
	try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);){
		DatabaseMetaData dbmd = con.getMetaData();
		System.out.println("Product Name:" + dbmd.getDatabaseProductName());
		System.out.println("Product Version:" + dbmd.getDatabaseProductVersion());
		System.out.println("Driver Name:" + dbmd.getDriverName());
		System.out.println("Driver Version:" + dbmd.getDriverVersion());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	private static void testUpdatableResultSet() {
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);) {

			// update Saad's pw

			ResultSet rs = stmt.executeQuery("SELECT USERNAME, PWD,LASTNAME FROM JAVA_USER");
			while (rs.next()) {
				String username = rs.getString(1);
				if (username.equalsIgnoreCase("s.saeed")) {
					rs.updateString("PWD", "abcd");
					rs.updateString(3,"Saeed");
					rs.updateRow();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void testCallableStatement() {
		String query = "Call getUserNameById(?,?)";
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
				CallableStatement cs = con.prepareCall(query);) {

			cs.setInt(1, 5); // userId
			cs.registerOutParameter(2, Types.VARCHAR);

			ResultSet rs = cs.executeQuery();
			System.out.println("The username is " + cs.getString(2));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void testBatchInsert() {
		String query = "INSERT INTO JAVA_USER(user_id, username, pwd, firstname, lastname) VALUES (?,?,?,?,?)";
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
				PreparedStatement ps = con.prepareStatement(query);) {
			con.setAutoCommit(false);

			// user 1
			ps.setInt(1, 2);
			ps.setString(2, "d.natta");
			ps.setString(3, "1234");
			ps.setString(4, "Daniel");
			ps.setString(5, "Natta");
			ps.addBatch();

			// user 2
			ps.setInt(1, 3);
			ps.setString(2, "a.ridout");
			ps.setString(3, "1234");
			ps.setString(4, "Alan");
			ps.setString(5, "Ridout");
			ps.addBatch();

			// user 3
			ps.setInt(1, 4);
			ps.setString(2, "s.saeed");
			ps.setString(3, "1234");
			ps.setString(4, "Saad");
			ps.setString(5, "Saeed");
			ps.addBatch();

			// user 4
			ps.setInt(1, 5);
			ps.setString(2, "a.nadir");
			ps.setString(3, "1234");
			ps.setString(4, "Abubakr");
			ps.setString(5, "Nadir");
			ps.addBatch();

			ps.executeBatch();
			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void retrieveDataUsingPreparedStatement(int id, String username) throws SQLException {
		String query = "SELECT FIRSTNAME, LASTNAME FROM JAVA_USER WHERE USER_ID = ? AND USERNAME LIKE ?";
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
				PreparedStatement ps = con.prepareStatement(query);) {
			ps.setInt(1, id);
			ps.setString(2, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				// String firstName = rs.getString(4);
				// String lastName = rs.getString(5);
				System.out.println("Name :" + firstName + " " + lastName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void retrieveDataUsingFilter(int id) throws SQLException {
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
				Statement stmt = con.createStatement();) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM JAVA_USER WHERE user_id = " + id);
			while (rs.next()) {
				String username = rs.getString("username");
				String pwd = rs.getString(3);
				String firstName = rs.getString(4);
				String lastName = rs.getString(5);
				System.out.println(
						id + ") " + " password: " + pwd + " First Name: " + firstName + " Last Name " + lastName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void retreiveDataUsingExecute() {
		String query = "SELECT * FROM JAVA_USER";
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
				Statement stmt = con.createStatement();) {
			boolean status = stmt.execute(query);

			if (status) {
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					int id = rs.getInt(1);
					// String username = rs.getString("username");
					String pwd = rs.getString(3);
					String firstName = rs.getString(4);
					String lastName = rs.getString(5);
					System.out.println(
							id + ") " + "password: " + pwd + "First Name: " + firstName + "Last Name " + lastName);
				}
			}

		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	private static void retreiveData() {
		String query = "SELECT * FROM JAVA_USER";
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
				Statement stmt = con.createStatement();) {
			// boolean status = stmt.execute(query);

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				// String username = rs.getString("username");
				String pwd = rs.getString(3);
				String firstName = rs.getString(4);
				String lastName = rs.getString(5);
				System.out
						.println(id + ") " + "password: " + pwd + "First Name: " + firstName + "Last Name " + lastName);

			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	private static void insertData() throws SQLException {
		String query = "INSERT INTO JAVA_USER(user_id, username, pwd, firstname, lastname) VALUES (1, 'jdoe', '1234','John', 'Doe')";
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
				Statement stmt = con.createStatement();) {
			int rowsAffected = stmt.executeUpdate(query);
			System.out.println("rows inserted successfully: " + rowsAffected);

		}

	}

	private static void createTable() {
		String query = "CREATE TABLE JAVA_USER(user_id NUMBER(6) PRIMARY KEY, username VARCHAR2(50), pwd VARCHAR(30), firstname VARCHAR2(50), lastname VARCHAR2(50))";
		// try with resources, try() can only use AutoCloseable implementing
		// resource
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
				Statement stmt = con.createStatement();) {
			stmt.execute(query);
			System.out.println("Table created...");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
