package homework20_maps;

import java.util.ArrayList;

public class Complex {
    private final ArrayList<Building> buildings;
    private final int numberOfBuildings;

    Complex(ArrayList<Building> buildings) {
        this.buildings = buildings;
        this.numberOfBuildings = buildings.size();
    }

    public String toString() {
        return "Complex with " + numberOfBuildings + " building" + (numberOfBuildings == 1 ? ":" : "s:") + "\n" +
                buildings;
    }
}
