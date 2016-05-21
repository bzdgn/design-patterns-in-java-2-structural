package structural.proxy;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterServiceImpl implements TwitterService {
	
	private static final String TWITTER_CONSUMER_KEY ="nGK4GtSnH0eDf7CMSEnWcLn93";
	private static final String TWITTER_CONSUMER_SECRET = "cqOC9cVzSgmuDHV8BaCmpiELIlLDhWuj166936Cs2zwAKhxctj";
	private static final String TWITTER_ACCESS_TOKEN = "1478357238-Msd9Pec3SuzRs9Rk0gmzBuMyYYWU22MS9WlccEn";
	private static final String TWITTER_ACCESS_TOKEN_SECRET = "8tQo6MleAD5MwaiTTriw4tpoMdxDfNU7e8FeQ3gWuTiG7";
	
	// twitter configuration
	private static final ConfigurationBuilder cb;
	private TwitterFactory tf;
	private Twitter twitter;
	
	// static parameters
	static {
		cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
		.setOAuthConsumerSecret(TWITTER_CONSUMER_SECRET)
		.setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
		.setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);
	}
	
	// constructor
	public TwitterServiceImpl() {
		tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();
	}
	
	@Override
	public String getTimeline(String screenName) {
//		ConfigurationBuilder cb = new ConfigurationBuilder();
//		cb.setDebugEnabled(true)
//			.setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
//			.setOAuthConsumerSecret(TWITTER_CONSUMER_SECRET)
//			.setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
//			.setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);
		
//		TwitterFactory tf = new TwitterFactory(cb.build());
//		Twitter twitter = tf.getInstance();
		StringBuilder builder = new StringBuilder();
		
		try{
			Query query = new Query(screenName);
			QueryResult result;
			do {
				result = twitter.search(query);
				List<Status> tweets=  result.getTweets();
				for(Status tweet : tweets) {
					builder.append("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
					builder.append("\n");
				}
			} while( (query = result.nextQuery()) != null);
		} catch(TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to search tweets: " + te.getMessage());
		}
		
		return builder.toString();
	}
	
	@Override
	public void postToTimeline(String screenName, String message) {
	    Status status;
		
	    try {
			status = twitter.updateStatus(message);
			System.out.println("Successfully updated the status to [" + status.getText() + "].");
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

}
