package structural.composite.levocustom;

import java.util.LinkedList;
import java.util.List;

public abstract class FileComponent {
	
	protected String name;
	protected List<FileComponent> fileComponents;
	
	public FileComponent(String name) {
		fileComponents = new LinkedList<FileComponent>();
		this.name = name;
	}
	
	public abstract void add(FileComponent fileComponent);
	public abstract void delete(FileComponent fileComponent);
	
	public abstract String toString();
	
	public String getContents() {
		return name;
	}
}
