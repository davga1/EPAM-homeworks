package homework11_buildings_dummyapp.buildings;

public class Employee {
    private final String name;
    private final String surname;

    Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }
}
