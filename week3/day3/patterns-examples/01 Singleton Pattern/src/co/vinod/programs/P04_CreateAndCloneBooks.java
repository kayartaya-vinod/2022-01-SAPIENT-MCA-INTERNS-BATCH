package co.vinod.programs;

import co.vinod.entity.Book;

public class P04_CreateAndCloneBooks {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Book b1 = new Book(123, "Let us C", 299);
		Book b2;
		
		b2 = b1; // 2 refs to one object
		
		
		b2 = b1.clone(); // cloning is done by the native method clone() in Object class 
		b2.setPrice(399);
		
		System.out.println(b1);
		System.out.println(b2);
		
	}
}
