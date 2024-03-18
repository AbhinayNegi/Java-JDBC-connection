package com.gkv.JavaProgramsUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	// All the necessory information is required to setup database connection with mysql
    	/* URL "jdbc:mysql://localhost:3306/gkv_abhinay", where localhost is the hostname 
    	 * of the MySQL server, 336 is the port number.
    	 * Username is the username of the database
    	 * And password contains password for the database
    	 * */
    	String url = "jdbc:mysql://localhost:3306/gkv_abhinay";
        String username = "root";
        String password = "admin";
        
        int id = 0;
        String name = null;
        
        // Connect to the MySQL database
        Connection connection = DriverManager.getConnection(url, username, password);
        
        // Creates a statement object to execute SQL queries
        Statement statement = connection.createStatement();
        
        // Define a query to select all data from the 'employees' table
        String query = "SELECT * FROM employees";
        
        // Execute the query and store the results in a ResultSet object
        ResultSet resultSet = statement.executeQuery(query);
        
        // Iterate through the result set (if any rows are returned)
        while(resultSet.next()) {
        	// Extract values from the row
        	id = resultSet.getInt("emp_id");
        	name = resultSet.getString("emp_name");
        }
        
        System.out.println("Id is :" + id + " and name is: " + name);
        
        // Prepare an insert query to add a new employee record
        String insertToDb = "INSERT INTO employees (emp_id, emp_name, emp_salary, emp_joining_date) VALUES (2, 'Laxmi', 200000, '2024-01-01')";
        
        // Execute the update query and store the number of affected rows
        int rowsAffected = statement.executeUpdate(insertToDb);
        
        // Check if the insert operation was successful
        if(rowsAffected > 0) {
        	System.out.println("Inserted");
        } else {
        	System.out.println("Failed");
        }
        
        // Close the connection to the database
        connection.close();
        
    }
}
