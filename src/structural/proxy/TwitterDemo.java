package structural.proxy;

public class TwitterDemo {

	public static void main(String[] args) {
//		TwitterService service = (TwitterService) SecurityProxy.newInstance(new TwitterServiceStub());
		
		TwitterService service = (TwitterService) SecurityProxy.newInstance(new TwitterServiceImpl());
		
		System.out.println(service.getTimeline("meliha_kaynak"));
		
		service.postToTimeline(null, "API Test #2: My dudeness... #dude #dudeism");
	}

}
