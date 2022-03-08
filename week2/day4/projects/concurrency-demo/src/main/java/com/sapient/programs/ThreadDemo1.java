package com.sapient.programs;

import com.sapient.entity.HelloThread;

public class ThreadDemo1 {
	
	

	public static void main(String[] args) {

		HelloThread t1 = new HelloThread();
		t1.start();
		
		// The "start()" method call allocates resources such as stack and stack frames, and
		// places the "public void run(){}" of the Thread class into the stack as the
		// first stack frame. After that the thread joins other threads in the scheduler with
		// the state as "runnable". When the time comes, it will change the state to "running",
		// during when code in "run()" method is executed.
		new HelloThread("welcome-thread").start();
		
		new HelloThread("nice-thread").start();
		
		for(;;) {
			System.out.println("In the thread " + Thread.currentThread().getName());
		}
	}

}
