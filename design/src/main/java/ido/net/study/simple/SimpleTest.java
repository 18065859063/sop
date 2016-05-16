package ido.net.study.simple;

/**
 * Created by ido on 2016/5/16.
 */

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述：单利模式四种写法：
 * 测试报告： 实例化用时20毫秒
 *               耗时     实例对象数量
 *      demo1:  2246        119
 *      demo2:  2942         1
 *      demo3:   2628             1
 *      demo4：2328          1
 *
 */
public class SimpleTest {


    public static void main( String[] args ) throws InterruptedException {

        Long start = System.currentTimeMillis();
        Long end = null;

        ExecutorService exe = Executors.newFixedThreadPool(10000);
        for(int i = 0; i < 10000; i++){
            Thread thread =   new Thread(){
                @Override
                public void run() {
                    SimpleDemo4 instance = SimpleDemo4.getInstance();
                    //  System.out.println("instance:"+instance);
                    synchronized (SimpleDemo4.map){
                        if(!SimpleDemo4.map.containsKey(instance)){
                            SimpleDemo4.map.put(instance, null);
                        }
                    }
                }
            };
            //   thread.start();
            exe.execute(thread);
        }

        exe.shutdown();

        int i = 0;
        while (true){
            if(exe.isTerminated()){
                // 输出map结果   java判断线程什么时候执行完成
                for(Map.Entry<Object, Object> entry: SimpleDemo4.map.entrySet()){
                    System.out.println("引用："+entry.getKey());
                    i++;
                }
                System.out.println("产生的应用次数："+i);
                end = System.currentTimeMillis();
                System.out.println("总共用时："+(end-start));
                break;
            }
            Thread.currentThread().sleep(200L);
        }
    }
}
