//Տան նկարագիրը իրա հերթին ներկայացնումա սենյակների քանակ, քառակուսի մետր, բաց բալկոնի առկայություն կամ ընդհակառակը, ու հարկը, որում գտնվումա տունը։

package homework20_maps;

import java.util.Objects;

public class House implements Comparable<House> {
    private final int numberOfRooms;
    private final double area;
    private final boolean containsBalcony;
    private final int floor;

    public House(int numberOfRooms, double area, boolean containsBalcony, int floor) {

        this.numberOfRooms = numberOfRooms;
        this.area = area;
        this.containsBalcony = containsBalcony;
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return numberOfRooms == house.numberOfRooms && Double.compare(area, house.area) == 0 && containsBalcony == house.containsBalcony && floor == house.floor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfRooms, area, containsBalcony, floor);
    }

    @Override
    public String toString() {
        return "\nHouse has " + numberOfRooms + " room" + (numberOfRooms == 1 ? "" : "s") + ", area is " + area + " m^2, " + (containsBalcony ? "Contains a balcony" : "Does not contain a balcony") + ", located on floor " + floor;
    }

    @Override
    public int compareTo(House o) {
        return Integer.compare(this.floor, o.floor);
    }
}
