import com.mongodb.BasicDBObject

class TwitterService {
    def twitterRestService
    def dbCon

    def saveTweets(params) {
        def db = dbCon.getDB()
        def restResult = twitterRestService.fetchTweets(params)
        if (restResult?.search_metadata?.count > 0) {
            restResult?.statuses?.each { tweet ->
                db.tweet.save(tweet)
            }
        }
    }

    def getTweets(params) {
        def data = []
        def db = dbCon.getDB()
        if (params.search) {
			String filter = """ { "text" : {\$regex : "${params.search}", \$options : "i"} }"""
            BasicDBObject filterObj = BasicDBObject.parse(filter)
            def cursor = db.tweet.find(filterObj)
            if (!cursor) {
                saveTweets(params)
                cursor = db.tweet.find(filterObj)
            }
            data = cursor?.toArray()
        }

        data.stream().collect({ tweet ->
            [
                    text: tweet.text,
                    name: tweet.user.name
            ]
        })
    }
}