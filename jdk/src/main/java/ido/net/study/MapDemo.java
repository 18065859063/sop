package ido.net.study;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ido on 2016/5/17.
 */

/**
 * 测试数据： 8000个线程同时访问
 *   hashMap
 *     产生的次数：7698
        总共用时：2135
    同步块的hashMap    === hashTable
        产生的次数：8000
        总共用时：2777
    conCurrentHashMap : 32把锁，每一次锁一个桶
        产生的次数：8000
        总共用时：2698
 *
 */
public class MapDemo {

    // 多线程访问会有多线程问题
    /**
     * 产生原因：
     *      多个操作组成的操作序列却可能导致数据争用，因为在操作序列中控制流取决于前面操作的结果
     */
  //  public static  Map<String, Object> map = new HashMap<String, Object>();

    // Collections.synchronizedMap 方法无法采用了修饰者模式，给map添加了线程同步块
  //  public static  Map<String, Object> map = Collections.synchronizedMap(new HashMap<String, Object>());

    //  ?? key.value 不能为空
    public  static  Map<String, Object> map = new ConcurrentHashMap();

    public static void main(String[] args) throws InterruptedException {

        Long start = System.currentTimeMillis();
        Long end = null;

        ExecutorService exe = Executors.newFixedThreadPool(8000);
        for(int i = 0; i < 8000; i++){
            Thread thread =  new MapThread(i);
            exe.execute(thread);
        }
        exe.shutdown();
        int i = 0;
        while (true){
            if(exe.isTerminated()){
                // 输出map结果   java判断线程什么时候执行完成
                for(Map.Entry<String, Object> entry: map.entrySet()){
                    System.out.println("引用："+entry.getKey());
                    i++;
                }
                System.out.println("产生的次数："+i);
                end = System.currentTimeMillis();
                System.out.println("总共用时："+(end-start));
                break;
            }
            Thread.currentThread().sleep(200L);
        }
    }

    static  class  MapThread extends  Thread{
        private int index;

        public MapThread(int index){
            this.index = index;
        }

        @Override
        public void run() {
            MapDemo.map.put(String.valueOf(index),String.valueOf(index));
        }
    }
  }
