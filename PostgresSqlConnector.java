package postgresDBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresSqlConnector {

	private String url;
	private String password;
	private String username;

	public PostgresSqlConnector(String url, String username, String password) {

		this.url = url;
		this.password = password;
		this.username = username;

	}

	public void executeQuery() throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//Class.forName("org.postgresql.Driver");

			myConn = DriverManager.getConnection(url, username, password);

			myStmt = myConn.createStatement();

			String query = "SELECT * FROM Animals";

			myRs = myStmt.executeQuery(query);

			while (myRs.next()) {
				System.out.println("Name: " + myRs.getString("animal_name"));
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (myConn != null) {
				myConn.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myRs != null) {
				myRs.close();
			}
		}

	}
}
