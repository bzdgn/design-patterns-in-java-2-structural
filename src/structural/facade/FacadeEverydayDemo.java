package structural.facade;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class FacadeEverydayDemo {

	public static void main(String[] args) throws Exception {
		
		URL url = new URL("http", "www.mkyong.com", 80, "/java/java-https-client-httpsurlconnection-example/");
		
		// Decorator Pattern here, InputStreamReader wrapped into a BufferedReader
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		
		String inputLine;
		
		while( (inputLine = in.readLine()) != null )
			System.out.println(inputLine);
		
	}

}
