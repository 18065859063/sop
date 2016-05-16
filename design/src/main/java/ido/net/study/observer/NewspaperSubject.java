package ido.net.study.observer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by ido on 2016/5/16.
 */
public class NewspaperSubject implements  Subject {

    private List<Observer> list = new LinkedList<Observer>();

    private Map<String, Object> data = new HashMap<String, Object>();
    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        synchronized (list){
            list.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for(Observer observer: list){
            observer.update(data);
        }
    }

    public void setData(String message){
        data.put("message", message);
    }
}
