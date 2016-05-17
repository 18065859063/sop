package ido.net.study.observer.custom;

/**
 * Created by ido on 2016/5/17.
 */
public interface Observer <T> {

    public void update(Subject subject, T obj);
}
