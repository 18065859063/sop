package ido.net.study.observer.custom;

/**
 * Created by ido on 2016/5/17.
 */
public interface Observable <T>{

    void registerObserver(Observer observer);

    boolean removeObserver(Observer observer);

    void notifyObserver(T t);

    void notifyObserver();
}
