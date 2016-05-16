package ido.net.study.simple;

/**
 * Created by ido on 2016/5/16.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 描述： 解决了simpleDemo1线程问题，但引入了预先加载问题
 * （万一单利没有使用到，当很耗时，导致没有必要的初始化）
 */
public class SimpleDemo2 {

    private static  SimpleDemo2 instance = new SimpleDemo2();

    public static volatile Map<Object, Object> map = new HashMap<Object, Object>();

    private SimpleDemo2(){
        try {
            Thread.currentThread().sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static  SimpleDemo2 getInstance(){
        return instance;
    }



}
