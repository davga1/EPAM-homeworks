package homework11_buildings_dummyapp.buildings;

public class Student {
    private String name;
    private String surname;
    private int age;

    Student(String name, String surname, int age) {
        setName(name);
        setSurname(surname);
        setAge(age);
    }

    public void setAge(int age) {   //setters
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() { //getters
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }
}
