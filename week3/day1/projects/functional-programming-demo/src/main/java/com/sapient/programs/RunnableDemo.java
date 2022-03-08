package com.sapient.programs;

public class RunnableDemo {

	static void delay(long duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			throw new RuntimeException(e); // exception wrapper; converting checked into an unchecked exception
		}
	}

	public static void main(String[] args) {

		// Thread t = new Thread();// t.target is null
		Thread t1 = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				delay(100);
				System.out.println(Thread.currentThread().getName() + " --> " + i);
			}
		}, "first-thread");
		// ()->{} is an arrow function, representing the only method in the Runnable
		// interface
		// which will eventually be put in the stack frame of this thread.

		t1.start(); // start the process of resource allocation to the thread and make the thread as
					// "Runnable" thread

		new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				delay(100);
				System.out.println(Thread.currentThread().getName() + " --> " + i);
			}
		}, "second-thread").start();

		for (int i = 1; i <= 10; i++) {
			delay(100);
			System.out.println(Thread.currentThread().getName() + " --> " + i);
		}
	}
}
