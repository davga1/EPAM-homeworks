package homework24;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            students.add(Student.generateRandomStudent());
        }
        System.out.println("Student list:");
        System.out.println(students);
//        System.out.println(Student.getFilteredStudents(students));
//        System.out.println(Student.increaseStudentsGrades(students));
//        System.out.println(Student.getGroupsByBirthYear(students));
//        System.out.println(Student.getAverageGrade(students));
//        System.out.println(Student.checkGradesOver45(students));
//        System.out.println(Student.getStudentWithMinimumGrade(students));
        System.out.println(Student.getStudentNames(students));
    }
}
