package de.telekom.jdbcchallenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {

		final String DRIVER = "org.mariadb.jdbc.Driver";
		final String URL = "jdbc:mariadb://localhost:3306/seadb?user=seauser&password=seapass";
		final String user = "seauser";
		final String password = "seapass";
		Class.forName(DRIVER);
		try {
			Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/seadb?user=seauser&password=seapass");
			Statement statement = connection.createStatement(  );
			ResultSet resultSet = statement.executeQuery( "select * from personen");
						
			while(resultSet.next()) {
			//	System.out.println("Anzahl Personen: " + select * from personen);
				System.out.print("ID " +resultSet.getInt(1) +", ");
				System.out.print("Anrede " +resultSet.getInt(2)+", "); 
			    System.out.print("Vorname " +resultSet.getString(3)+", "); 
			    System.out.print("Nachname " +resultSet.getString(4)); 
			    System.out.println();
			}
			
			String sql = ;
		PreparedStatement preparedStatement = connection.prepareStatement(sql );  //siehe Frederick 16:00
			//preparedStatement.executeSQL( "INSERT INTO personen( ?, ?, ? ");
			
			preparedStatement.setInt(1, 4);
			preparedStatement.setInt(2, 1);
			preparedStatement.setString(3, "Paul");
			preparedStatement.setString(4, "Paulsen");

			preparedStatement.execute();
			
			
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Exception");
		}

		
		
	}

}
