package homework10_classes2.teacher;

public class Main {
    static double K = 2;
    static int minSalary = 65000;

    public static void main(String[] args) {
        Teacher.setK(K);
        Teacher.setMinSalary(minSalary);
        Teacher a = new Teacher(35, "Mathematics");
        Teacher b = new Teacher(45, "Physics");
        System.out.println("Teachers minimal salary is " + minSalary + "\ncoefficient is " + K);
        System.out.println(a.getSubject() + " teacher's w coefficient is " + a.getW() + " and his salary is " + Teacher.getMinSalary() + " * " + Teacher.getK() + " * " + a.getW() + " = " + a.getSalary());
        System.out.println(b.getSubject() + " teacher's w coefficient is " + b.getW() + " and his salary is " + Teacher.getMinSalary() + " * " + Teacher.getK() + " * " + b.getW() + " = " + b.getSalary());
    }
}
