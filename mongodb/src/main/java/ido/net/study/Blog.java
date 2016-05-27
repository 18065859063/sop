package ido.net.study;

/**
 * Created by ido on 5/27/16.
 */

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
public class Blog {

    private  String id;

    private String name;

    private String type;

    private Integer count;

    private Info info;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", count=" + count +
                ", info=" + info +
                '}';
    }
}
