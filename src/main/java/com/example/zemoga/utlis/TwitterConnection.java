package com.example.zemoga.utlis;

import com.example.zemoga.config.TwitterConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

@Service
@Log4j2
public class TwitterConnection {

    private final static String FROM_KEY = "from:";

    private final TwitterConfig twitterConfig;
    private Twitter twitter;

    @Autowired
    public TwitterConnection(TwitterConfig twitterConfig) {
        this.twitterConfig = twitterConfig;
        init();
    }

    private void init() {
        if (twitter == null) {
            ConfigurationBuilder cb = new ConfigurationBuilder().setOAuthConsumerKey(twitterConfig.getTwitterKey())
                    .setOAuthConsumerSecret(twitterConfig.getTwitterSecretKey())
                    .setOAuthAccessToken(twitterConfig.getTwitterToken())
                    .setOAuthAccessTokenSecret(twitterConfig.getTwitterSecretToken());
            TwitterFactory tf = new TwitterFactory(cb.build());
            twitter = tf.getInstance();
        }
    }

    public List<Status> getTimelineUSer(String user) {
        List<Status> twitters = null;
        try {
            Query query = new Query(FROM_KEY.concat(user));
            query.setCount(twitterConfig.getLimit());
            QueryResult result = twitter.search(query);
            twitters = result.getTweets();
        } catch (TwitterException e) {
            log.error(e);
        }
        return twitters;
    }
}
