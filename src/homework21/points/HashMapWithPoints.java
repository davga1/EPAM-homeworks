package homework21.points;

import java.util.HashMap;

public class HashMapWithPoints {
    private final HashMap<Point, String> points;

    HashMapWithPoints() {
        points = new HashMap<>();
    }

    public void addPoint(Point point, String name) {
        points.put(point, name);
    }

    public HashMap<Point, String> getPoints() {
        return points;
    }
}