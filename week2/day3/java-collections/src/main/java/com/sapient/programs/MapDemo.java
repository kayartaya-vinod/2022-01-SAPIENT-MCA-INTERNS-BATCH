package com.sapient.programs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MapDemo {

    public static void main(String[] args) {
        Map<String, String> data = new HashMap<>();
        data.put("Vinod", "Bangalore");
        data.put("Naveen", "Bangalore");
        data.put("Vinay", "Hassan");
        data.put("Pranav", "Vasco");
        data.put("Nived", "Nagpur");
        data.put("Vinod", "Shivamogga");

        System.out.println(data);

        // get a specific value based on key
        String val = data.get("Vinod");
        System.out.println("value for key Vinod is " + val);

        // remove element by key
        data.remove("Vinod");
        System.out.println("After removing Vinod, data is " + data);

        // get only keys
        Set<String> keys = data.keySet();
        System.out.println("keys = " + keys);
        for (String k : keys) {
            System.out.println(k + " --> " + data.get(k));
        }

        // get only values
        Collection<String> vals = data.values();
        System.out.println("vals = " + vals);

        // a set of entries (key+val)
        Set<Entry<String, String>> entries = data.entrySet();
        for (Entry<String, String> e : entries) {
            System.out.println(e.getKey() + " --> " + e.getValue());
        }

    }
}
