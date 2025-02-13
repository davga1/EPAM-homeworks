//Ստեղծել մի քանի Student օբյեկտներ և ավելացնել դրանք լիստի մեջ:
//Ստեղծել մեթոդ processStudents, որը ստանում է ուսանողների ցուցակը և Consumer<Student>,
// այնուհետև կանչում է տվյալ Consumer-ի accept() մեթոդը ցուցակի յուրաքանչյուր էլեմենտի համար:
//Լամբդա արտահայտություններով իրականացնել հետևյալ գործողությունները՝
//Տպել ուսանողների տվյալները։
//-Բարձրացնել բոլոր ուսանողների գնահատականները 10%-ով։
//-Տպել միայն այն ուսանողների անունները, որոնց գնահատականը մեծ է 90-ից։
//Նույն գործողությունները անել method reference-ով, որտեղ հնարավոր է։

package homework23;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    //Տպել ուսանողների տվյալները։
    static void processStudents(List<Student> studentList, Consumer<Student> studentConsumer) {
        studentList.forEach(studentConsumer);
    }

    //-Բարձրացնել բոլոր ուսանողների գնահատականները 10%-ով։
    static void updateGrades(List<Student> studentList) {
        studentList.forEach(
                Student::upgradeGradeForStudent
        );
    }

    //-Տպել միայն այն ուսանողների անունները, որոնց գնահատականը մեծ է 90-ից։
    static void printBestStudents(List<Student> studentList) {
        System.out.print("{");
        studentList.forEach(Student::checkGrades);
        System.out.print("}");
    }

    static Function<String, Integer> getYear = Integer::parseInt;

    //Օգտագործել Function ֆունկցիոնալ ինտերֆեյսը և Integer::parseInt, որպեսզի փոխակերպեք birthYear-ը int և հաշվեք ուսանողի տարիքը։
    static Integer getStudentAge(Student student) {
        return 2025 - getYear.apply(student.getBirthYear());
    }


    public static void main(String[] args) {
        Consumer<Student> studentConsumer = student -> System.out.println(student.getName() + "," + student.getBirthYear() + "," + student.getAge() + "," + student.getGrade());
        Student student = new Student("Andrew", 12, 54, "2013");
        List<Student> listOfStudents = List.of(
                student,
                new Student("Arnie", 13, 68, "2012"),
                new Student("Vahe", 20, 85, "2005"),
                new Student("Davit", 21, 95, "2004"),
                new Student("Suren", 21, 90, "2004"),
                new Student("Andrey", 19, 75, "2005"));
        System.out.println("Before upgrading grades");
        processStudents(listOfStudents, studentConsumer);
        updateGrades(listOfStudents);
        System.out.println("After upgrading grades");
        processStudents(listOfStudents, studentConsumer);
        printBestStudents(listOfStudents);
        System.out.println(getStudentAge(student));
    }
}
