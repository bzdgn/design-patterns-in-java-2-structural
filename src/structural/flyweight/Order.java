package structural.flyweight;

public class Order {
	
	private final int orderNumber;
	private final Item item;
	
	Order(int orderNumber, Item item) {
		this.orderNumber = orderNumber;
		this.item = item;
	}
	
	public void processOrder() {
		System.out.println("Ordering " + item + " for order number " + orderNumber);
	}
	
}
