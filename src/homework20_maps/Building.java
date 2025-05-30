//Թաղամասները բաղկացած են շենքերից, որոնցում մեզ հետաքրքիրա հարկերի քանակը, փառքինգի քանակը, ու իրանում առկա յուրաքանչյուր տունը՝ իրա նկարագրով։
package homework20_maps;

import homework20_maps.exceptions.IncorrectFloorException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Building {
    private final int numberOfFloors;
    private final int numberOfParkingFloors;
    private final ArrayList<House> houses;

    Building(int numberOfFloors, int numberOfParkingFloors, ArrayList<House> houses) {
        this.numberOfFloors = numberOfFloors;
        this.numberOfParkingFloors = numberOfParkingFloors >= 2 ? numberOfParkingFloors : 1;
        for (House h : houses) {
            if (h.getFloor() > this.numberOfFloors) {
                throw new IncorrectFloorException("Floor number exceeds building floors");
            }
        }
        Collections.sort(houses);
        this.houses = houses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return numberOfFloors == building.numberOfFloors && numberOfParkingFloors == building.numberOfParkingFloors && Objects.equals(houses, building.houses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfFloors, numberOfParkingFloors, houses);
    }

    @Override
    public String toString() {
        return "\nBuilding with " + numberOfFloors + " floor" + (numberOfFloors == 1 ? "" : "s ") + "and " + numberOfParkingFloors + " parking floor" + (numberOfParkingFloors == 1 ? "." : "s.") + "\nHouses: " + houses;
    }
}
