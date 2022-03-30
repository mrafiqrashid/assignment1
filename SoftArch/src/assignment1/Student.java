package assignment1;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Student {
	public static void main(String[] args) throws SQLException {
// Connect to database
		Connection conn = null;
		
		String connectionURL = "jdbc:mysql://localhost:3306/db1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=TRUE&useSSL=FALSE";
		
		conn = DriverManager.getConnection(connectionURL, "root", "MRafiq2601$");
// Create a statement to retrieve objects
		Statement s = conn.createStatement();
// Retrieve results from the table
		ResultSet rs = s.executeQuery("Select * from student");
// Print columns headers
		ResultSetMetaData rsmd = rs.getMetaData();
		int i = rsmd.getColumnCount();
		for (int j = 1; j <= i; j++) {
			System.out.print(rsmd.getColumnName(j) + "\t");
			System.out.print(" ");
		}
// Print records
		while (rs.next()) {
			for (int j = 1; j <= i; j++) {
				System.out.print(rs.getString(j) + "\t");
			}
		}
	}
}