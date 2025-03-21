//Իսկ հիվանդանոցի մասով դուք կարաք ունենաք հիվանդասենյակներ,
//որոնց քանակությունը կրկին Hospital-ի օբյեկտը սարքելու ժամանակ կարաք տաք։
//Ձեր հիվանդանոցը պետքա ունենա ցուցակ, որտեղ թվարկված կլինեն էն հիվանդություննները,
//որոնք բուժվում են էնտեղ (կարաք շատ չխորանաք ու մի 5-6 հիվանդության անուն նշեք ցուցակում),
//ինչպես նաև աշխատող բժշկական անձնակազմի քանակ։ Պետքա ունենաք մեթոդ, որով հնարավորություն ունենաք հեռացնեք աշխատողի,
//որի անուն ազգանունը String-ի տեսքով պետքա ստանա տվյալ մեթոդը։
//Պայմանական, Ձեր մեթոդը պիտի տպի համապատասխան հաղորդագրություն տվյալ աշխատողին հեռացնելու մասին ու պակասացնի անձնակազմի քանակությունը։

package homework11_buildings_dummyapp.buildings;

public class Hospital extends Building {
    private int rooms;
    private final String[] diseases = {"Pneumonia", "Hepatitis", "Diabetes", "Hypertension", "Tuberculosis"};
    private int employeesCount;

    Hospital(int outletCount, int voltage, int rooms, int employeesCount) { // hospital with cusom parameters
        super(outletCount, voltage);
        setRooms(rooms);
        setEmployeesCount(employeesCount);
    }

    Hospital() { //default Hospital
        super();
        setRooms(20);
        setEmployeesCount(40);
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String[] getDiseases() {
        return diseases;
    }

    public int getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(int employeesCount) {
        this.employeesCount = employeesCount;
    }

    public void removeEmployee(Employee employee) {
        if (employeesCount > 0) {
            employeesCount--;
            System.out.println("Now hospital has " + employeesCount + " employees, because " + employee.getName()
                    + " " + employee.getSurname() + " was fired");
        }
    }
}
