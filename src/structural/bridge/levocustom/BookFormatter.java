package structural.bridge.levocustom;

import java.util.List;

public class BookFormatter implements Formatter {

	@Override
	public String format(String header, List<Detail> details) {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Book Genre : " + header + "\n");
		builder.append("***************************************\n");
		
		for(Detail detail : details) {	
			builder.append("\t" + detail.getLabel() + " : ");
			
			if(!detail.getLabel().equals("Number Of Pages"))
				builder.append("\t");
			
			builder.append("\t" + detail.getValue() + "\n");
		}
		
		return builder.toString();
	}

}
