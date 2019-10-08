
import grails.converters.JSON

class TwitterController{

	def twitterService
	def twitterRestService


	def index(){
		println("test")
		render view: "index.gsp"
	}
	
	def getTweets(){
		def data = twitterService.getTweets(params)
		def returnString = [data:"no results"]
		if(data){
			def model = [data: data]
			render model as JSON
		}else{
			render returnString as JSON 
		}
	}


}