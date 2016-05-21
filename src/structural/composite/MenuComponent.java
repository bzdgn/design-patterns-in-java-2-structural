package structural.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuComponent {
	
	String name;
	String url;
	List<MenuComponent> menuComponents = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	
	public String getUrl() {
		return url;
	}
	
	public abstract String toString();
	
	String print(MenuComponent menuComponent) {
		StringBuilder builder = new StringBuilder(name);
		
		builder.append(": ");
		builder.append(url);
		builder.append("\n");
		
		return builder.toString();
	}
	
}
