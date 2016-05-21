package structural.composite.enhanced;

public class CompositeMenuEnhancedDemo {

	public static void main(String[] args) {
		
		Menu mainMenu = new Menu("Main", "/main");
		
		MenuItem safetyMenuItem = new MenuItem("Safety", "/safety");
		
		mainMenu.add(safetyMenuItem);
		
		Menu claimsSubMenu = new Menu("Claims", "/claims");
		
		mainMenu.add(claimsSubMenu);
		
		MenuItem personalClaimsMenu = new MenuItem("Personal Claim", "/personalClaims");
		
		claimsSubMenu.add(personalClaimsMenu);
		
		// Comment out to see UnsupportedOperationException at this level
//		personalClaimsMenu.add(new MenuItem("Last Step", "/lastStep"));
		
		System.out.println(mainMenu.toString());
		
	}

}
