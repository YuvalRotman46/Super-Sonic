package game;

import java.util.Objects;

public class Point {
    public double x, y;

    public Point(double x, double y){
        this.x = x;
        this.y =y;
    }

    public Point(Point other){
        this.x = other.x;
        this.y = other.y;
    }

    public Point(){x = 0; y = 0; }

    public void move(double dx, double dy){
        x += dx;
        y += dy;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
