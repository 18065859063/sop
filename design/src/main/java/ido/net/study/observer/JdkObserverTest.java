package ido.net.study.observer;

import java.util.*;

/**
 * Created by ido on 2016/5/16.
 */
public class JdkObserverTest {

    static  class  NewspaperSubject extends Observable {

        public void setChange(){
            super.setChanged();
        }

    }

    static  class  ReaderObserver implements java.util.Observer{

        private String reader;

        public ReaderObserver(String reader){
            this.reader = reader;
        }

        @Override
        public void update(Observable o, Object arg) {
            String message = (String) arg;
            System.out.println("读者："+reader+","+"消息："+message);
        }
    }

    public static void main(String[] args) {
        //
        NewspaperSubject subject = new NewspaperSubject();



        // 书店出了一本新书， 通知所有的读者消息
        ReaderObserver reader1 = new ReaderObserver("小小");
        subject.addObserver(reader1);

        ReaderObserver reader2 = new ReaderObserver("咪咪");
        subject.addObserver(reader2);

        ReaderObserver reader3 = new ReaderObserver("秀秀");
        subject.addObserver(reader3);

        subject.setChange();
        subject.notifyObservers("上架了一本新书!");

        // 移除秀秀
        subject.deleteObserver(reader1);
        subject.setChange();
        subject.notifyObservers("新书上线了，欢迎过来使用！");






    }
}
