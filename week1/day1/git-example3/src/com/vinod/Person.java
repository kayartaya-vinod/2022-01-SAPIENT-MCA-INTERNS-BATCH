package com.vinod;

// @author: Vinod Kumar Kayartaya
public class Person {

    private String name;
    private String email;
    private String phone;

    // TODO: add constructors and setters/getters along with toString

    public Person() {
    }

    public Person(String name, String email, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    
    public Person(String name, String email){
        this.name = name;
        this.email = email;
    }
}
