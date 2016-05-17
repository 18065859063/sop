package ido.net.study.observer.custom;

/**
 * Created by ido on 2016/5/17.
 */
public class ReaderObserver implements  Observer<String>{

    private String reader;

    public ReaderObserver(String reader){
        this.reader = reader;
    }

    @Override
    public void update(Subject subject, String obj) {
        System.out.println("读者是："+this.reader+","+"报社消息："+obj);
    }
}
