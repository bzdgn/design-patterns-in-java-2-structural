package structural.composite.levocustom;

public class Directory extends FileComponent {

	public Directory(String name) {
		super(name);
	}

	@Override
	public void add(FileComponent fileComponent) {
		fileComponents.add(fileComponent);
	}

	@Override
	public void delete(FileComponent fileComponent) {
		fileComponents.remove(fileComponent);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("/" + name + "\n");
		
		for(FileComponent file : fileComponents)
			builder.append("\t" + file.toString() + "\n");
		
		return builder.toString();
	}
	
	
	
}
