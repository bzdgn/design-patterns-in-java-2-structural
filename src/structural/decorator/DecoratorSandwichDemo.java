package structural.decorator;

public class DecoratorSandwichDemo {

	public static void main(String[] args) {
		Sandwich sandwich = new DressingDecorator(new MeatDecorator(new SimpleSandwich()));
		
//		Sandwich sandwich = new MeatDecorator(new DressingDecorator(new SimpleSandwich()));
		
		System.out.println(sandwich.make());
	}

}
