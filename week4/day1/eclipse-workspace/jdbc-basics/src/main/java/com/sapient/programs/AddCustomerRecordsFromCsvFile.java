package com.sapient.programs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sapient.utils.DbUtil;

public class AddCustomerRecordsFromCsvFile {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		String sql = "insert into customers values(?, ?, ?, ?, ?, ?)";
		
		try(
			Connection conn = DbUtil.createConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
		){
			
			String filename = "customers.csv";
			File file = new File(filename);
			
			Files
				.lines(file.toPath())
				.forEach(line -> {
					String[] arr = line.split(",");
					try {
						int id = Integer.parseInt(arr[0]);
						String name = arr[1];
						String email = arr[2];
						String phone = arr[3];
						String city = arr[4];
						
						// sometimes there is no value for "state", hence this conditional check
						String state = arr.length==6 ?  arr[5]: "";
						
						// set the values for question marks (parameters)
						stmt.setInt(1, id);
						stmt.setString(2, name);
						stmt.setString(3, email);
						stmt.setString(4, phone);
						stmt.setString(5, city);
						stmt.setString(6, state);
						
						// stmt.execute(); // send all the six parameter values to the db server
						stmt.addBatch();
						
					} catch (Exception ex) {
						// duck the exception; and move on with the next line
						System.out.println("Got an error - " + ex.getMessage());
					}
					
					
				});
			
			stmt.executeBatch(); // send the batches of data
			
			System.out.println("Records added to the customers table.");
			
		}
	}

}
