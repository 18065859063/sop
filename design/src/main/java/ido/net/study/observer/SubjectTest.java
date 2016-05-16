package ido.net.study.observer;

/**
 * Created by ido on 2016/5/16.
 */
public class SubjectTest {

    public static void main(String[] args) {

        NewspaperSubject subject = new NewspaperSubject();

        ReaderObserver observer1 = new ReaderObserver("小小");
        subject.registerObserver(observer1);

        ReaderObserver observer2 = new ReaderObserver("敏敏");
        subject.registerObserver(observer2);

        ReaderObserver observer3 = new ReaderObserver("雪雪");
        subject.registerObserver(observer3);


        subject.setData("今天有一本新书上架了");
        subject.notifyObserver();

        subject.removeObserver(observer1);
        subject.removeObserver(observer1);
        subject.notifyObserver();




    }
}
