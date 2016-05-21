package structural.bridge.levocustom;

import java.util.LinkedList;
import java.util.List;

public class BookPrinter extends Printer {
	
	private Book book;
	
	public BookPrinter(Book book) {
		this.book = book;
	}
	
	@Override
	protected String getHeader() {
		return book.getGenre();
	}

	@Override
	protected List<Detail> getDetails() {
		List<Detail> details = new LinkedList<>();
		
		details.add(new Detail("Author", book.getAuthor()));
		details.add(new Detail("Title" , book.getTitle()));
		details.add(new Detail("Publish", book.getPublishYear() + ""));
		details.add(new Detail("Number Of Pages", book.getNumberOfPages() + ""));
		details.add(new Detail("Available", (book.isAvailable() == true) ? "Yes" : "No"));
		
		return details;
	}

}
