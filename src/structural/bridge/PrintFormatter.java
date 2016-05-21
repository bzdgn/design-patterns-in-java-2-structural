package structural.bridge;

import java.util.List;

public class PrintFormatter implements Formatter {

	@Override
	public String format(String header, List<Detail> details) {
		StringBuilder builder = new StringBuilder();
		
		builder.append(header + "\n");
		for(Detail detail : details)
			builder.append(detail.getLabel() + ": " + detail.getValue() + "\n");
		
		return builder.toString();
	}

}
