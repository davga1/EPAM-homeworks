//Կան նաև դպրոցներ, որոնք ունեն էնտեղ սովորող աշակերտներ ու ուսուցիչներ՝ ինչ-որ քանակություններով։
//Դուք պետքա հնարավորություն ունենաք վերցնեք աշակերտների ու ուսուցիչների քանակը։
//Ինչպես նաև հնարավորություն ունեք ավելացնելու նոր աշակերտի, որը բնորոշվումա 3 փռոփերթիով` անուն, ազգանուն, տարիք (String-ով չպահել էս ինֆոն, այլ նենց, ոնց ձեզ պետքա հուշի OOP-ն)։
//Աշակերտների մաքսիմում քանակը տվյալ դպրոցում տրվումա դպրոցի օբյեկտը սարքելու ժամանակ։
//Եթե լրացելա աշակերտների քանակը, նոր աշակերտ ավելացնելու դեպքում զուտ հաղորդագրություն պիտի տպվի,
//որ տեղերն արդեն լրացվել են ու նոր աշակերտ չի կարա ավելանա։

package homework11_buildings_dummyapp.buildings;

public class School extends Building {
    private int numberOfStudents;
    private final int numberOfTeachers;
    private final int maxNumberOfStudents;

    School() {
        maxNumberOfStudents = 100;
        numberOfTeachers = 25;
        numberOfStudents = 100;
    }

    School(int outletsCount, int voltage, int numberOfStudents, int numberOfTeachers, int maxNumberOfStudents) { //new school with given parameters
        super(outletsCount, voltage);
        this.numberOfStudents = numberOfStudents;
        this.numberOfTeachers = numberOfTeachers;
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    School(int maxNumberOfStudents, int numberOfStudents) { //default school without parameters
        super();
        this.maxNumberOfStudents = maxNumberOfStudents;
        numberOfTeachers = 10;
        this.numberOfStudents = numberOfStudents;
    }

    School(School school) { // copy of school object
        numberOfStudents = school.numberOfStudents;
        numberOfTeachers = school.numberOfTeachers;
        maxNumberOfStudents = school.maxNumberOfStudents;
    }

    public void addStudent(Student student) {
        if (numberOfStudents < maxNumberOfStudents) {
            numberOfStudents++;
            System.out.println("Added a new student in school with name " + student.getName() + ", surname " + student.getSurname()
                    + ",age " + student.getAge() + ",He is student number " + numberOfStudents);
        } else {
            System.out.println("There is no more place to add students, school already reached it's maximum number");
        }
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public int getNumberOfTeachers() {
        return numberOfTeachers;
    }
}

