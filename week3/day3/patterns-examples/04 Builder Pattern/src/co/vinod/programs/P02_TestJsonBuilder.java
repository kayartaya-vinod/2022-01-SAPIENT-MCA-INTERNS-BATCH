package co.vinod.programs;

import java.util.HashMap;
import java.util.Map;

import co.vinod.pattenrs.JsonBuilder;

public class P02_TestJsonBuilder {

	public static void main(String[] args) {
		
		Map<String, Object> address= new HashMap<>();
		address.put("city", "Bangalore");
		address.put("pincode", 560078);
		address.put("state", "Karnataka");
		
		
		String json = new JsonBuilder()
			.addProperty("firstname", "Vinod")
			.addProperty("lastname", "Kumar")
			.addProperty("email", "vinod@vinod.co")
			.addProperty("age", 48)
			.addProperty("isMarried", true)
			.addArrayProperty("phoneNumbers", "9731424784", 26661911, false)
			// .addMapProperty("address", address);
			.build(); 

		System.out.println(json);

	}

}
