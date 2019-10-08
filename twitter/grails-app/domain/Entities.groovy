
import grails.mongodb.*
class 	Entities implements MongoEntity<Entities> {
	String _id
	    String[] hashtags
	    String[] symbols
	    String[] user_mentions
	    String[] urls

	static mapping = {
        collection "entities"
        database "twitter"
    }
    static mapWith = "mongo"
}