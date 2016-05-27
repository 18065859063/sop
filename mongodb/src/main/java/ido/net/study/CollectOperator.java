package ido.net.study;

import com.mongodb.*;
import com.sun.javafx.scene.layout.region.BackgroundPositionConverter;
import com.sun.javafx.scene.layout.region.BorderImageSliceConverter;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ido on 5/27/16.
 */
public class CollectOperator {

    //get collect


    // add
    public static  void add(DBCollection collection, BasicDBObject object){
        collection.insert(object);
    }

    public static DBCollection getCollection(DB db, String blog) {
        return db.getCollection(blog);
    }

    public static Blog find(DBCollection collection, DBObject whereObject, DBObject limitObject) {

        Blog blog = new Blog();
        DBCursor dbCursor  = collection.find(whereObject, limitObject);
        while (dbCursor.hasNext()){
            DBObject result = dbCursor.next();
            blog.setCount((Integer) result.get("count"));
            blog.setName((String) result.get("name"));
            blog.setType((String) result.get("type"));
            ObjectId id = (ObjectId) result.get("_id");
            if(id != null){
                blog.setId(id.toString());
            }
        }
        return blog;
    }

    public static List<Blog> findAll(DBCollection collection, DBObject whereDb, DBObject limitDb) {
       List< Blog> blogList = new ArrayList<Blog>();
        DBCursor dbCursor  = collection.find(whereDb, limitDb);
        while (dbCursor.hasNext()){
            Blog blog = new Blog();
            DBObject result = dbCursor.next();
            blog.setCount((Integer) result.get("count"));
            blog.setName((String) result.get("name"));
            blog.setType((String) result.get("type"));
            ObjectId id = (ObjectId) result.get("_id");
            if(id != null){
                blog.setId(id.toString());
            }
            blogList.add(blog);
        }
        return blogList;
    }

    //delete

    //update

    //find

    //findAll


}
