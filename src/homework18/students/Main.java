package homework18.students;

import java.util.ArrayList;
import java.util.Collections;

import static homework18.contains_or_not.ContainsOrNot.containsOrNot;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        StudentGrades student1 = new StudentGrades("Mike", 55, 65, 35);
        StudentGrades student2 = new StudentGrades("Michael", 85, 45, 35);
        StudentGrades student3 = new StudentGrades("Archie", 40, 95, 50);
        StudentGrades student4 = new StudentGrades("George", 66, 99, 69);
        ArrayList<StudentGrades> arrayList = new ArrayList<>();
        arrayList.add(student1);
        arrayList.add(student2);
        arrayList.add(student3);
        System.out.println(containsOrNot(arrayList, student4));
        arrayList.add(student4);
        Collections.sort(arrayList);
        System.out.println(arrayList);
    }
}
