package structural.proxy.facebook;

public class FacebookDemo {

	public static void main(String[] args) {
		FacebookService service = new FacebookServiceImpl();
		
//		service.postStatus("API test !");
		service.getNewsFeed();
	}

}
