//Պատկերացրեք, որ ունեք 3D կետերի հավաքածու, որոնք բնորոշվում են իրանց կոորդինատներով, գույնով, ու կետին տրված անունով։
//Կետերը նույնականացվում են իրանց բոլոր փռոփերթիներով, ու բոլոր փռոփերթիները կարևոր նկարագրություն են տվյալ 3D կետի համար։
package homework21.points;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private final int x;
    private final int y;
    private final int z;
    private final String color;
    private final String name;

    Point(int x, int y, int z, String color, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.color = color;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, color, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y && z == point.z && Objects.equals(color, point.color) && Objects.equals(name, point.name);
    }

    @Override
    public int compareTo(Point o) {
        int compareX = Integer.compare(x, o.x);
        if (compareX != 0) return compareX;
        int compareY = Integer.compare(y, o.y);
        if (compareY != 0) return compareY;
        int compareZ = Integer.compare(z, o.z);
        if (compareZ != 0) return compareZ;
        return color.compareTo(o.color);
    }

    public String toString() {
        return "[\nx:" + x + "\ny:" + y + "\nz:" + z + "\ncolor:" + color + "\nname:" + this.name + "]";
    }
}
