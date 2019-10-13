import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
class TwitterRestService{

	def tUrl = 'https://api.twitter.com/1.1/search/tweets.json?'
    def grailsApplication

	def fetchTweets(params){
		RestBuilder rest = new RestBuilder()
        String url = "${grailsApplication.config.getProperty('twitter.api.url')}q={search}"

        RestResponse restResponse = rest.get(url) { 
            urlVariables params
            contentType "application/json"
            auth grailsApplication.config.getProperty('twitter.api.auth')
        }

        if ( restResponse.statusCode.value() == 200 && restResponse.json ) {
            return restResponse.json 
        }
        null
	}
}