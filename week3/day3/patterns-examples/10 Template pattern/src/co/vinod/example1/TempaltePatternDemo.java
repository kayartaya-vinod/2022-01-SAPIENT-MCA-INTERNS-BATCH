package co.vinod.example1;

public class TempaltePatternDemo {

	public static void main(String[] args) {

		Machine m;
		m = new DrillingMachine();
		m.operate();
	}

}

abstract class Machine {
	
	// template method; missing part is filled/provided by subclasses 
	public void operate() {
		System.out.println("Starting to operate the machine...");
		startMachine();
		System.out.println("Running the machine now...");
		runMachine();
		System.out.println("Going to stop the machine now...");
		stopMachine();
	}
	
	// blanks or placeholders
	abstract void startMachine();
	abstract void runMachine();
	abstract void stopMachine();
}

class DrillingMachine extends Machine {

	@Override
	void startMachine() {
		System.out.println("Drilling machine started!");
	}

	@Override
	void runMachine() {
		System.out.println("Drilling going on...");
	}

	@Override
	void stopMachine() {
		System.out.println("Drilling stopped!");
		
	}
	
}