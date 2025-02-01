package homework20_maps;

import homework20_maps.exceptions.ComplexNotFoundException;
import homework20_maps.exceptions.IncorrectFloorException;
import homework20_maps.houses.Houses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static String getAddress(HashMap<Complex, String> complexMap, Complex complex) throws ComplexNotFoundException {
        if (!complexMap.containsKey(complex)) throw new ComplexNotFoundException("Complex is not found");
        return "Complex found with ID:" + complexMap.get(complex);
    }

    public static void main(String[] args) {
        Building building1 = new Building(2, 0, new ArrayList<House>(List.of(Houses.h1, Houses.h2)));
        Building building2 = new Building(3, 5, new ArrayList<House>(List.of(Houses.h3, Houses.h4, Houses.h5)));
        Building building3 = new Building(1, 1, new ArrayList<House>(List.of(Houses.h1, Houses.h5, Houses.h9)));
        Building building4 = new Building(3, 2, new ArrayList<House>(List.of(Houses.h6, Houses.h8, Houses.h10)));
        Complex complex1 = new Complex(new ArrayList<>(List.of(building1, building2)));
        Complex complex2 = new Complex(new ArrayList<>(List.of(building3, building4)));
        Complex complex3 = new Complex(new ArrayList<>(List.of(building3, building4)));
        HashMap<Complex, String> complexesMap = new HashMap<>();
        complexesMap.put(complex1, "Avangard 4");
        complexesMap.put(complex2, "Yolyan 1");
        try {
            System.out.println(getAddress(complexesMap, complex3));
        } catch (IncorrectFloorException | ComplexNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
