package ido.net.study.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ido on 2016/5/16.
 */
public interface Subject {


    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObserver();

}
