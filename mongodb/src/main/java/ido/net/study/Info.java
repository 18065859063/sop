package ido.net.study;

/**
 * Created by ido on 5/27/16.
 */
public class Info {

    private Double x;

    private Double y;

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Info{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
