package com.sapient.entity;

public class HelloThread extends Thread {

	public HelloThread() {
		super("hello-thread");
	}

	public HelloThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (;;) {
			System.out.println("In the thread " + Thread.currentThread().getName());
		}
	}

}
