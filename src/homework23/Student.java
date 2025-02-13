//Ստեղծել դաս Student, որն ունի հետևյալ դաշտերը՝
//String name
//int age
//double grade
//String birthYear (որպես String)
//Ստեղծել մի քանի Student օբյեկտներ և ավելացնել դրանք լիստի մեջ:
//Ստեղծել մեթոդ processStudents, որը ստանում է ուսանողների ցուցակը և Consumer<Student>,
// այնուհետև կանչում է տվյալ Consumer-ի accept() մեթոդը ցուցակի յուրաքանչյուր էլեմենտի համար:
//Լամբդա արտահայտություններով իրականացնել հետևյալ գործողությունները՝
//Տպել ուսանողների տվյալները։
//-Բարձրացնել բոլոր ուսանողների գնահատականները 10%-ով։
//-Տպել միայն այն ուսանողների անունները, որոնց գնահատականը մեծ է 90-ից։
//Նույն գործողությունները անել method reference-ով, որտեղ հնարավոր է։
//*****աստղանիշով))))))
//Օգտագործել Function ֆունկցիոնալ ինտերֆեյսը և Integer::parseInt, որպեսզի փոխակերպեք birthYear-ը int և հաշվեք ուսանողի տարիքը։
package homework23;

import java.util.function.Consumer;

public class Student {
    private String name;
    private int age;
    private double grade;
    private String birthYear;

    Student(String name, int age, double grade, String birthYear) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.birthYear = birthYear;
    }

    public void a() {
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

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void upgradeGradeForStudent() {
        setGrade((grade * 10) / 100 + grade);
    }

    public void checkGrades() {
        if (grade >= 90) {
            System.out.println(this);
        }
    }

    public String toString() {
        return (name + "," + birthYear + "," + age + "," + grade);
    }
}
