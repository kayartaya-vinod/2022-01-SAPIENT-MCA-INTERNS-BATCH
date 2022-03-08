package co.vinod.patterns;

public class File implements IFile {

	private String name;

	public File(String name) {
		this.name = name;
	}

	@Override
	public void print() {
		for (int i = 0; i < Directory.INDENT; i++) {
			System.out.print(" ");
		}
		System.out.print("File: " + name + "\n");
	}

}
