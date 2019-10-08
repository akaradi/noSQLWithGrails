import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
class TwitterRestService{

	def tUrl = 'https://api.twitter.com/1.1/search/tweets.json?' 

	def fetchTweets(params){
		println("insite  RestBuilder")
		RestBuilder rest = new RestBuilder()
        String url = "${tUrl}q={search}"

        RestResponse restResponse = rest.get(url) { 
            urlVariables params
            contentType "application/json"
            auth "Bearer AAAAAAAAAAAAAAAAAAAAANRILgAAAAAAnNwIzUejRCOuH5E6I8xnZz4puTs%3D1Zv7ttfk8LF81IUq16cHjhLTvJu4FA33AGWWjCpTnA"
        }

        if ( restResponse.statusCode.value() == 200 && restResponse.json ) {
            return restResponse.json 
        }
        println(restResponse.statusCode.value())
        null
	}
}