package ido.net.study;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

/**
 * Created by ido on 5/27/16.
 */
public class MongoDbHelper {

    private  static MongoClient mongoClient ;

    private static DB db;
    private static  String databaseName = "mongdbtest";

    public static DB getConnection()  {

        if(mongoClient == null){

            try {
                /**
                 * 登陆验证
                 *
                     MongoCredential credential = MongoCredential.createCredential(userName, database, password);
                    MongoClient mongoClient = new MongoClient(new ServerAddress(), Arrays.asList(credential));

                 */
                mongoClient = new MongoClient("localhost", 27017);
                if(db == null){
                    db = mongoClient.getDB(databaseName);
                }

            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        return  db;

    }


}
