//Գեներացնել 20 ուսանողի ցուցակ պատահական տվյալներով (օգտագործեք մեթոդ նրանց գեներացնելու համար)։
//Գտնել և տպել այն ուսանողների անունները, ովքեր համապատասխանում են հետևյալ չափանիշներին՝
//Նրանց տարիքը 18-ից 22-ի սահմաններում է։
//Նրանց գնահատականը 60-ից 80-ի սահմաններում է։
//Ստեղծել ուսանողների ցուցակ, որոնց գնահատականները բարձրացված են 15%-ով, բայց համոզվել, որ ոչ մի գնահատական չի գերազանցում 80-ը։
//Ուսանողներին խմբավորել ծննդյան տարվա հիման վրա և տպել յուրաքանչյուր տարում ուսանողների քանակը։
//Գտնել և հաշվարկել 20 և բարձր տարիք ունեցող ուսանողների միջին գնահատականը։ Արդյունքը մշակել Optional-ով։
//Ստուգել՝ արդյո՞ք բոլոր ուսանողների գնահատականները 45-ից բարձր են, և տպել արդյունքը։
//Գտնել ամենացածր գնահատական ունեցող ուսանողին և տպել։
//Ստեղծել ուսանողների անունների ստորակետերով բաժանված տող, որոնց անունները դասավորված են այբբենական կարգով, և տպել արդյունքը։
//Ֆիլտրել և ուսանողներին խմբավորել ըստ գնահատականների (60< , 60 - 70, > 70) և տպել խմբերը։
//Գտնել ամենաերիտասարդ ուսանողին
//Այս Բոլորի համար կարող եք օգտագործել նախորդ տնայինի Student կլասը․ և Stream
package homework24;

import java.util.*;
import java.util.stream.Collectors;

public class Student {
    private final String name;
    private final int age;
    private double grade;
    private final String birthYear;

    Student(String name, int age, double grade, String birthYear) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.birthYear = birthYear;
    }

    public double getGrade() {
        return grade;
    }

    public int getAge() {
        return age;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getName() {
        return name;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void upgradeGradeOfStudent(double percent) {
        setGrade((grade * percent) / 100 + grade);
    }

    public void checkGrades() {
        if (grade >= 90) {
            System.out.println(this);
        }
    }

    public static Student generateRandomStudent() {
        Random random = new Random();

        String[] names = {"Davit", "Armine", "Vahe", "Artak", "Tigran", "Andrey", "Tamara", "Narine", "Suren", "Andranik"};
        String studentName = names[random.nextInt(10)];
        int studentAge = random.nextInt(18) + 19; //At least 20 years old
        int year = 2025 - studentAge;
        double studentGrade = random.nextDouble(100);
        String studentBirthYear = String.valueOf(year);
        return new Student(studentName, studentAge, studentGrade, studentBirthYear);
    }

    //Գտնել և տպել այն ուսանողների անունները, ովքեր համապատասխանում են հետևյալ չափանիշներին՝
    //Նրանց տարիքը 18-ից 22-ի սահմաններում է։
    //Նրանց գնահատականը 60-ից 80-ի սահմաններում է։
    public static List<Student> getFilteredStudents(List<Student> students) {
        System.out.println("Filtered student list:");
        return students.stream().filter(student -> student.getAge() >= 18 &&
                        student.getAge() <= 22 && student.getGrade() >= 60 && student.getGrade() <= 80)
                .toList();
    }

    //Ստեղծել ուսանողների ցուցակ, որոնց գնահատականները բարձրացված են 15%-ով, բայց համոզվել,
    // որ ոչ մի գնահատական չի գերազանցում 80-ը։
    public static List<Student> increaseStudentsGrades(List<Student> students) {
        System.out.println("Students grades, increased by 15%");
        return students.stream().map(student -> {
                    double newGrade = student.grade + (student.grade * 15 / 100);
                    if (newGrade > 80) {
                        newGrade = 80;
                    }
                    return new Student(student.name, student.age, newGrade, student.birthYear);
                }
        ).toList();
    }

    //Ուսանողներին խմբավորել ծննդյան տարվա հիման վրա և տպել յուրաքանչյուր տարում ուսանողների քանակը։

    public static Map<String, Integer> getGroupsByBirthYear(List<Student> students) {
        Map<String, Integer> map = new HashMap<>();
        students.forEach(student -> {
            map.put(student.birthYear, map.getOrDefault(student.birthYear, 0) + 1);
        });
        return map;

    }

    //Գտնել և հաշվարկել 20 և բարձր տարիք ունեցող ուսանողների միջին գնահատականը։ Արդյունքը մշակել Optional-ով։
    public static OptionalDouble getAverageGrade(List<Student> students) {
        return students.stream()
                .filter(student -> student.age >= 20)
                .mapToDouble(student -> student.grade)
                .average();
    }

    //Ստուգել՝ արդյո՞ք բոլոր ուսանողների գնահատականները 45-ից բարձր են, և տպել արդյունքը։
    public static boolean checkGradesOver45(List<Student> students) {
        return students.stream()
                .allMatch(student -> student.grade > 45);
    }

    //Գտնել ամենացածր գնահատական ունեցող ուսանողին և տպել։

    public static Student getStudentWithMinimumGrade(List<Student> students) {
        Optional<Student> studentWithMinimumGrade = students.stream()
                .min(Comparator.comparingDouble(student -> student.grade));
        return studentWithMinimumGrade.map(student -> new Student(student.name, student.age,
                student.grade, student.birthYear)).orElse(null);
    }

    //Ստեղծել ուսանողների անունների ստորակետերով բաժանված տող, որոնց անունները դասավորված են այբբենական կարգով, և տպել արդյունքը։
    public static List<String> getStudentNames(List<Student> students) {
        return students.stream().map(student -> student.name).sorted().toList();
    }

    //Ֆիլտրել և ուսանողներին խմբավորել ըստ գնահատականների (60< , 60 - 70, > 70) և տպել խմբերը։
    public static Map<String, Student> getGroupOfStudentsByGrades(List<Student> students) {
        Map<String, List<Student>> map = students.stream().collect(Collectors.groupingBy(student -> {
            if (student.grade < 60) return "<60";
            if (student.grade >= 60 && student.grade <= 80) return "60-80";
            return ">60";
        }));
        Map<String, Student> m = new HashMap<>();
        map.forEach((s, students1) -> m.put(s, students1));
    }

    public String toString() {
        return ("\nName:" + name + ",Birth year:" + birthYear + ",Age:" + age + ",Grade:" + grade);
    }
}
