package ido.net.study.observer.custom;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Redefinable;

/**
 * Created by ido on 2016/5/17.
 */
public class ObTest {

    public static void main(String[] args) {
        // 创建报社
        NewspagerSubject subject = new NewspagerSubject();

        // 创建读者    并订阅报社
        ReaderObserver reader1 = new ReaderObserver("小小");
        subject.registerObserver(reader1);
        ReaderObserver reader2 = new ReaderObserver("雪雪");
        subject.registerObserver(reader2);
        ReaderObserver reader3 = new ReaderObserver("妞妞");
        subject.registerObserver(reader3);

        // 报社通知读者
        subject.notifyObserver("最新上架了一本新书");

        // 小小取消订阅
        subject.removeObserver(reader1);

        subject.notifyObserver("钢铁的时间上架，有需要的过来过来");

    }
}
