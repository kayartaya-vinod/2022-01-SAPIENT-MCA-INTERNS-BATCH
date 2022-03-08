package com.sapient.programs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {

	public static void main(String[] args) throws Exception {

		// tasks
		Runnable t1 = () -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			System.out.println("Running the Runnable task...");

		};

		Callable<String> t2 = () -> {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			}
			System.out.println("Running the Callable task...");
			return "Hello";
		};

		ExecutorService executor;
		executor = Executors.newFixedThreadPool(10);

		Future<?> f1 = executor.submit(t1); // one of the thread from the pool is assigned t1.run() as job
		Future<String> f2 = executor.submit(t2); // another thread from the pool is assigned t2.call() as a job

		Object obj = f1.get();
		System.out.println("Return value represented by f1 from the task t1 is " + obj);

		String val = f2.get();
		System.out.println("Return value represented by f2 from the task t2 is " + val);

		executor.shutdown();
		System.out.println("End of main!");

	}
}
