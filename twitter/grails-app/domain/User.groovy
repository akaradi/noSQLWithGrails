import grails.mongodb.*
class User implements MongoEntity<User> {
	
	String _id
	String name
	String screen_name
	String location
	String description
	String url
	String protectedd
	Long followers_count
	Long friends_count
	Long listed_count
	String created_at
	Long favourites_count
	String utc_offset
	String time_zone
	String geo_enabled
	String verified
	Long statuses_count
	String lang
	String contributors_enabled
	boolean is_translator
	boolean is_translation_enabled
	String profile_background_color
	String profile_background_image_url
	String profile_background_image_url_https
	String profile_background_tile
	String profile_image_url
	String profile_image_url_https
	String profile_banner_url
	String profile_link_color
	String profile_sidebar_border_color
	String profile_sidebar_fill_color
	String profile_text_color
	String profile_use_background_image
	String has_extended_profile
	String default_profile
	String default_profile_image
	String following
	String follow_request_sent
	String notifications
	String translator_type

	static mapping = {
        collection "user"
        database "twitter"
    }

    static mapWith = "mongo"

    String toString(){
    	name
    }

}