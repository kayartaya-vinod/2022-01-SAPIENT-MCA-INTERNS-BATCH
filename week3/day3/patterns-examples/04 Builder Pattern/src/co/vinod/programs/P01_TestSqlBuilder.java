package co.vinod.programs;

import co.vinod.pattenrs.SqlBuilder;

public class P01_TestSqlBuilder {
	public static void main(String[] args) {
		
		SqlBuilder sb = new SqlBuilder();
		String sql = sb.from("customers")
			.join("orders", "orders.customer_id=customers.id")
			.where("email like ?", "%gmail%")
			.whereOr("state like ?", "%Karnataka%")
			.order("city", "asc")
			.order("name", "asc")
			.build();
		
		
		System.out.println(sql);
		System.out.println(sb.values());
		
		String sql1 = new SqlBuilder().from("EMPLOYEES")
			.where("salary > ?", 56000)
			.whereOr("depart_no=?", 20)
			.order("salary", "desc")
			.order("name", "asc")
			.build();
		
		System.out.println(sql1);
			
	}
}
// create a class called JsonBuilder, which allows the user to add property/value one after the other,
// Continuously, and then generate (build) a json string for the same. 