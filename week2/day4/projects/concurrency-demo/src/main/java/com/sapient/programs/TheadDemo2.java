package com.sapient.programs;

public class TheadDemo2 {

	public static void main(String[] args) throws Exception {
		
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					System.out.println("Inside anonymous Runnable instance, i is " + i);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		
		
		Thread t1 = new Thread(r1);
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<30; i++) {
					System.out.println("Inside another anonymous Runnable instance, i is " + i);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					}
				}
			}
		});
		
		Thread t3 = new Thread(() -> {
			for(int i=0; i<20; i++) {
				System.out.println("Inside arrow function as Runnable instance, i is " + i);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		System.out.println("End of main()");
		
	}
}
