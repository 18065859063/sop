package ido.net.study.observer;

import java.util.Map;

/**
 * Created by ido on 2016/5/16.
 */
public class ReaderObserver implements  Observer {

    private String readerName;

    public ReaderObserver(String readerName){
        this.readerName = readerName;
    }

    @Override
    public void update(Map<String, Object> data) {
        String message = (String) data.get("message");
        System.out.println("作者："+readerName+", 报社消息："+message);
    }
}
