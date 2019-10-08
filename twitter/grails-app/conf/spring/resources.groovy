import com.mongodb.*
// Place your Spring DSL code here
beans = {
	dbCon(DbConnImpl){
        mongoClient = ref("mongo_client")
        dbName = "twitter"
    }

    mongo_client(MongoClient, "localhost", 27017)
    

}

class DbConnImpl {
    MongoClient mongoClient
    String dbName

    public DB getDB(){
        return mongoClient.getDB(dbName)
    }

    void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient
    }

    void setDbName(String dbName) {
        this.dbName = dbName
    }
}