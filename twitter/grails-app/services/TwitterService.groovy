import grails.converters.JSON
import java.util.*
import java.util.stream.*

class TwitterService{
	def twitterRestService
	def dbCon
	
	def saveTweets(params){
		def db = dbCon.getDB()
		def restResult = twitterRestService.fetchTweets(params)
		if(restResult?.search_metadata?.count>0){
			restResult?.statuses?.each{tweet ->
				db.tweet.save(tweet)
			}	
		}
	}

	def getTweets(params){
		def data = []
		def db = dbCon.getDB()
		if (params.search) {
			def cursor = db.tweet.find()
	        if(!cursor){
				saveTweets(params)
				cursor = db.tweet.find()
			}
			data = cursor?.toArray()
	    }
		Arrays 
            .stream(data) 
            .collect(Collectors.toList())
	}
}