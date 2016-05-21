package structural.composite.levocustom;

public class CompositeCustomDemo {

	public static void main(String[] args) {
		File file1 = new File("OnemliNot.txt");
		File file2 = new File("Yapilacaklar.txt");
		
		Directory dr1 = new Directory("Notlar");
		dr1.add(file1);
		dr1.add(file2);
		
//		System.out.println(dr1);
		
		File music1 = new File("HurdaciMuharrem.ra");
		File music2 = new File("bok.mp3");
		
		Directory dr2 = new Directory("Muzak");
		dr2.add(music1);
		dr2.add(music2);
		
//		System.out.println(dr2);
		
		File list = new File("Liste.txt");
		Directory topDr = new Directory("Kisisel");
		topDr.add(dr1);
		topDr.add(dr2);
		topDr.add(list);
		
//		list.add(new File("hayvan.txt"));
		
		System.out.println(topDr);
	}

}
