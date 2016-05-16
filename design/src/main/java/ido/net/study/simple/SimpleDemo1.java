package ido.net.study.simple;

/**
 * Created by ido on 2016/5/16.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 常用的写法：
 *  缺陷： 存在线程冲突问题, 多线程下面会产生多个实例
 *  产生的主要原因取决创建实例的时间
 */
public class SimpleDemo1 {

    private static  SimpleDemo1 instance;

    public static volatile Map<Object, Object> map = new HashMap<Object, Object>();

    private SimpleDemo1(){
        try {
            Thread.sleep(10L);
        }catch (Exception e){
            e.printStackTrace();;
        }
    }

    public static SimpleDemo1 getInstance(){
        if(instance == null){
            instance = new SimpleDemo1();
        }
        return instance;
    }

}
