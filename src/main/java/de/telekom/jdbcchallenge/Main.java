package de.telekom.jdbcchallenge;

import java.sql.Connection;
import java.sql.DriverManager;
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
			ResultSet resultSetAnzahl = statement.executeQuery( "select count(*) from personen");
			System.out.println("Anzahl Personen: " +resultSetAnzahl);
			
			ResultSet resultSet = statement.executeQuery( "select * from personen");
			
			while(resultSet.next()) {
				System.out.print("ID " +resultSet.getInt(1) +" ,");
				System.out.print("Anrede " +resultSet.getInt(2)); 
			    System.out.print("Vorname " +resultSet.getString(3)); 
			    System.out.print("Nachname " +resultSet.getString(4)); 
			    System.out.println();
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Exception");
		}

		
		
	}

}
