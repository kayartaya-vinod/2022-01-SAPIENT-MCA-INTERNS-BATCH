package com.sapient.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CheckForPrimesUsingExecutorService {

	public static void main(String[] args) throws Exception {

		ExecutorService executor = Executors.newFixedThreadPool(100);

		List<Callable<Object[]>> callables = new ArrayList<>();
		for (int num = 1; num <= 100; num++) {
			callables.add(new CheckForPrime(num));
		}
		List<Future<Object[]>> futureResults = executor.invokeAll(callables);

		for (Future<Object[]> result : futureResults) {
			System.out.println(Arrays.toString(result.get()));
		}

		executor.shutdown();
	}

	static class CheckForPrime implements Callable<Object[]> {

		private final Integer num;

		public CheckForPrime(Integer num) {
			this.num = num;
		}

		@Override
		public Object[] call() throws Exception {

			for (int i = 2, limit = num / 2; i <= limit; i++) {
				if (num % i == 0) {
					return new Object[] { num, false };
				}
			}

			return new Object[] { num, true };
		}

	}

}
