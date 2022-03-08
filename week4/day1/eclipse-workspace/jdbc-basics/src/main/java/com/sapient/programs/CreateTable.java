package com.sapient.programs;

import java.io.File;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.Statement;

import com.sapient.utils.DbUtil;

public class CreateTable {

	public static void main(String[] args) throws Exception{
		
		// try-with-resource block to properly close resources
		try(
			Connection conn = DbUtil.createConnection();
			Statement stmt = conn.createStatement();
		){
			File file = new File("customers.sql");
			String cmd = Files.readString(file.toPath());
			
			stmt.execute(cmd); // actual sql command is now sent to the server for execution
			System.out.println("Table created successfully!");
		}
	}
}
