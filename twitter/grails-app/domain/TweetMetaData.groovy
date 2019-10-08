import grails.mongodb.*
class TweetMetaData implements MongoEntity<TweetMetaData> {
	String _id
	String result_type
	String iso_language_code

	static mapping = {
        collection "tweetMetaData"
        database "twitter"
    }

    static mapWith = "mongo"
}