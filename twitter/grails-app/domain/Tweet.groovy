
import User
import Entities
import TweetMetaData

import grails.mongodb.*
import org.bson.types.ObjectId;


class Tweet implements MongoEntity<Tweet> {
	
	String _id
	String created_at
	String text 
	boolean truncated
	Entities entities
	User user
	TweetMetaData metaData
	String source
	String in_reply_to_status_id
	String in_reply_to_status_id_str
	String in_reply_to_user_id
	String in_reply_to_user_id_str
	String in_reply_to_screen_name
	String geo
	String coordinates
	String place
	String contributors
	boolean is_quote_status
	Long retweet_count
	Long favorite_count
	boolean favorited
	boolean retweeted
	String lang

	static mapping = {
        collection "tweet"
        database "twitter"
    }

    static mapWith = "mongo"

    String toString(){
    	text
    }
}