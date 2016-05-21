package structural.proxy.facebook;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;

public class FacebookServiceImpl implements FacebookService {
	
	//https://developers.facebook.com/sa/apps/1592971154364833/settings/
	//https://developers.facebook.com/tools/accesstoken/
	
	private static final String FACEBOOK_APP_ID			= "1592971154364833";
	private static final String FACEBOOK_APP_SECRET		= "0eee1a1fb4549a9dad13bb8466df974c";
	private static final String FACEBOOK_ACCESS_TOKEN	= "EAAWozHZCLGaEBAMZCtDB8k6HJAH3yLPKy9rrK5kEPdagwbVOPKQ4KrnEM4D1g55JTEdm83noLLezJvyabM6iLksyjoNeEuyP39e8yXfVrFvXDYIQA8179NKrx2f4IiyjkDaBr6DNZBps4FmK8EZB8w3WZBYIWV1UeANq9RmjzDAZDZD";
	
	// facebook configuration
	private static final ConfigurationBuilder cb;
	private FacebookFactory ff;
	private Facebook facebook;
	
	static {
		cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthAppId(FACEBOOK_APP_ID)
		.setOAuthAppSecret(FACEBOOK_APP_SECRET)
		.setOAuthAccessToken(FACEBOOK_ACCESS_TOKEN)
		.setOAuthPermissions("status_update");
	}
	
	public FacebookServiceImpl() {
		ff = new FacebookFactory(cb.build());
		facebook = ff.getInstance();
	}

	@Override
	public String getNewsFeed() {
		StringBuilder builder = new StringBuilder();
		
		try {
			ResponseList<Post> feed = facebook.getFeed("723701760999457", new Reading().limit(25));
			
			System.out.println(feed.get(0).getMessage());
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void postStatus(String message) {
		try {
			facebook.postStatusMessage(message);
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
