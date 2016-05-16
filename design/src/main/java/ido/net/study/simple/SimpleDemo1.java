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
 */
public class SimpleDemo1 {

    private static  SimpleDemo1 instance;

    private static volatile Map<Object, Object> map = new HashMap<Object, Object>();

    private SimpleDemo1(){

    }

    public static SimpleDemo1 getInstance(){
        if(instance == null){
            try {
                Thread.sleep(200L);
            }catch (Exception e){
                e.printStackTrace();;
            }

            instance = new SimpleDemo1();
        }
        return instance;
    }

    public static void main( String[] args ) throws InterruptedException {

        ExecutorService exe = Executors.newFixedThreadPool(1000);

        for(int i = 0; i < 1000; i++){
          Thread thread =   new Thread(){
                @Override
                public void run() {
                    SimpleDemo1 instance = SimpleDemo1.getInstance();
                  //  System.out.println("instance:"+instance);
                    synchronized (map){
                        if(!map.containsKey(instance)){
                            map.put(instance, null);
                        }
                    }
                }
            };
         //   thread.start();
            exe.execute(thread);
        }

        exe.shutdown();

        while (true){
            if(exe.isTerminated()){
                // 输出map结果   java判断线程什么时候执行完成
                for(Map.Entry<Object, Object> entry: map.entrySet()){
                    System.out.println("引用："+entry.getKey());
                }
                break;
            }
            Thread.currentThread().sleep(200L);
        }
    }

}
