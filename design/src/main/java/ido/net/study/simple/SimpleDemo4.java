package ido.net.study.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ido on 2016/5/16.
 */
public class SimpleDemo4 {

    public static volatile Map<Object, Object> map = new HashMap<Object, Object>();

    private static SimpleDemo4 instance;

    private SimpleDemo4(){
        try {
            Thread.currentThread().sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static SimpleDemo4 getInstance(){
        if(instance == null){
            synchronized (map){
                if(instance == null){
                    instance = new SimpleDemo4();
                }
            }
        }
        return instance;
    }

}
