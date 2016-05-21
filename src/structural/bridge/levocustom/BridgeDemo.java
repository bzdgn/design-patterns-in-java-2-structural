package structural.bridge.levocustom;

public class BridgeDemo {

	public static void main(String[] args) {
		Movie movie = new Movie();
		movie.setClassification("Action");
		movie.setTitle("John Wick");
		movie.setRuntime("2:15");
		movie.setYear("2014");
		
		Formatter printFormatter = new PrintFormatter();
		Printer moviePrinter = new MoviePrinter(movie);
		
		String printedMaterial = moviePrinter.print(printFormatter);
		
		System.out.println(printedMaterial);
		
		Book book = new Book();
		book.setAuthor("Levo D.");
		book.setAvailable(true);
		book.setGenre("Scifi");
		book.setNumberOfPages(314);
		book.setPublishYear(1998);
		book.setTitle("A New Hope");
		
		Printer bookPrinter = new BookPrinter(book);
		Formatter bookFormatter = new BookFormatter();
		
		String printedBook = bookPrinter.print(bookFormatter);
//		String printedBook = bookPrinter.print(printFormatter);
		
		
		System.out.println(printedBook);
	}

}
