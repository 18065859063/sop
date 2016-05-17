package ido.net.study.observer.custom;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ido on 2016/5/17.
 */
public class Subject<T> implements  Observable<T>{

    private Map<Observer, Object>  observerMap = new ConcurrentHashMap<Observer, Object>();

    public void registerObserver(Observer observer){
        observerMap.put(observer, observer);
    }

    public boolean removeObserver(Observer observer){
        return observerMap.remove(observer) == null ? false:true;
    }

    public void notifyObserver(){
        notifyObserver(null);
    }

    public void notifyObserver(T object){
        Set<Observer> set = observerMap.keySet();
        for(Observer observer: set){
            observer.update((Observable)Subject.this, object);
        }
    }
}
