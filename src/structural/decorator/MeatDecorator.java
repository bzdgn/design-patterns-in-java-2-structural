package structural.decorator;

public class MeatDecorator extends SandwichDecorator {

	public MeatDecorator(Sandwich customSandwich) {
		super(customSandwich);
	}
	
	@Override	// is it needed ?
	public String make() {
		return customSandwich.make() + addMeat();
	}
	
	private String addMeat() {
		return " + turkey";
	}
	
}
