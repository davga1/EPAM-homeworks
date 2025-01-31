package homework20_maps;

import java.util.ArrayList;
import java.util.Objects;

public class Complex {
    private final ArrayList<Building> buildings;
    private final int numberOfBuildings;

    Complex(ArrayList<Building> buildings) {
        this.buildings = buildings;
        this.numberOfBuildings = buildings.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return numberOfBuildings == complex.numberOfBuildings && Objects.equals(buildings, complex.buildings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buildings);
    }

    @Override
    public String toString() {
        return "Complex with " + numberOfBuildings + " building" + (numberOfBuildings == 1 ? ":" : "s:") + "\n" + buildings;
    }
}
