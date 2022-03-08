package com.sapient.programs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sapient.utils.DbUtil;
import com.sapient.utils.KeyboardUtil;

public class GetCustomersFromState {

	public static void main(String[] args) throws Exception {

		String state = KeyboardUtil.getString("Enter state: "); // Porto or Lisboa or California
		String sql = "select * from customers where state = ?"; 

		try (Connection conn = DbUtil.createConnection(); PreparedStatement stmt = conn.prepareCall(sql);

		) {
			stmt.setString(1, state);
			// this is when the actual SQL command in the server is associated with
			// the parameter value and execution is done
			try (ResultSet rs = stmt.executeQuery()) {
				// rs initially points to "beforeFirst"
				
				System.out.printf("%3s %-20s %-30s %-12s %-15s\n",
						"ID", "Name", "Email", "Phone", "City");
				System.out.println("-".repeat(85));
				
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String email = rs.getString(3); // use column name instead
					String phone = rs.getString("phone");
					String city = rs.getString("city");
					
					System.out.printf("%3d %-20s %-30s %-12s %-15s\n",
							id, name, email, phone, city);
				}
			}
		}
	}

}
