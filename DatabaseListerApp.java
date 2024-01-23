package postgresDBConnection;

import java.sql.SQLException;

public class DatabaseListerApp {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/test";
		String password = "SuperMaria20";
		String username = "postgres";
		
		PostgresSqlConnector connector = new PostgresSqlConnector(url, username, password);
		
		connector.listDatabases();
	}

}
