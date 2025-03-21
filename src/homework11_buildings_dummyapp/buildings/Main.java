package homework11_buildings_dummyapp.buildings;

public class Main {
    public static void main(String[] args) {
        School a = new School(15, 150, 15, 15, 15);
        School b = new School();
        School c = new School(200, 150);
        Student newStudent = new Student("Armen", "Armenich", 15);
        a.addStudent(newStudent);
        b.addStudent(newStudent);
        c.addStudent(newStudent);

        Hospital d = new Hospital();
        System.out.println("Hospital has " + d.getRooms() + " rooms and " + d.getEmployeesCount() + "workers");
        System.out.print("Hospital can cure ");
        String[] diseases = d.getDiseases();
        for (int i = 0; i < diseases.length - 2; i++) {
            System.out.print(diseases[i] + ",");
        }
        System.out.print(diseases[diseases.length - 2] + " and " + diseases[diseases.length - 1] + "\n");
        Employee e = new Employee("David", "Galstyan");
        Employee f = new Employee("Andranik", "Galstyan");
        d.removeEmployee(e);
        d.removeEmployee(f);
    }
}