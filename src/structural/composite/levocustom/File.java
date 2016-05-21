package structural.composite.levocustom;

public class File extends FileComponent {
	
	public File(String name) {
		super(name);
	}

	private static String errMsg = "File cannot add/remove FileComponent object";
	
	@Override
	public void add(FileComponent fileComponent) {
		handleError();
	}

	@Override
	public void delete(FileComponent fileComponent) {
		handleError();
	}
	
	private static void handleError() {
		throw new UnsupportedOperationException(errMsg);
	}

	@Override
	public String toString() {
		return "\t/" + name;
	}

}
