package ido.net.study.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ido on 2016/5/16.
 */
public class SimpleDemo3 {

    public static volatile Map<Object, Object> map = new HashMap<Object, Object>();

    private static SimpleDemo3 instance;

    private SimpleDemo3(){
        try {
            Thread.currentThread().sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized SimpleDemo3 getInstance(){
        if(instance == null){
             instance = new SimpleDemo3();
        }
        return instance;
    }

}
