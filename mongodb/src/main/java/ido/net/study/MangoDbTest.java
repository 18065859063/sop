package ido.net.study;

import com.mongodb.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by ido on 5/27/16.
 */
public class MangoDbTest {


    DBCollection collection ;

    @Before
    public void first(){
        DB db = MongoDbHelper.getConnection();
         collection = CollectOperator.getCollection(db, "blog");
    }

    /**
         * {
             "name" : "MongoDB",
             "type" : "database",
             "count" : 1,
             "info" : {
                x : 203,
                 y : 102
             }
         }
     */
    @Test
    public  void add(){
        BasicDBObject object = new BasicDBObject();
        object.append("name","ido1")
                .append("type","database2")
                .append("count",4)
                .append("info", new BasicDBObject()
                        .append("x", 2013)
                        .append("y", 1012));
        CollectOperator.add(collection,object);

    }

    @Test
    public void findOne(){
        DBObject whereDb = new BasicDBObject();
        whereDb.put("name", "ido");

        DBObject limitDb = new BasicDBObject();
        limitDb.put("type",1);
        limitDb.put("_id", 0);

        Blog blog = CollectOperator.find(collection, whereDb, limitDb);
        System.out.println(blog);
    }

    @Test
    public void findAll(){
        DBObject whereDb = new BasicDBObject();
        whereDb.put("count", new BasicDBObject().append("$gt", 2).append("$lt", 5));

        DBObject limitDb = new BasicDBObject();

        List<Blog> blogList = CollectOperator.findAll(collection, whereDb, limitDb);
        blogList.stream().forEach(blog ->{
            System.out.println(blog);

        });
    }

    @Test
    public void delete(){
        collection.remove(new BasicDBObject().append("name", "ido1"));
    }

    @Test
    public void update(){
        collection.update(new BasicDBObject().append("type", "database").append("name", "MongoDb"),
                new BasicDBObject().append("$set", new BasicDBObject().append("counttest", 10)), false ,true);
    }

    public void test(){

    }
}
