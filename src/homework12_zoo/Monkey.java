package homework12_zoo;

public class Monkey implements Animal, PerformTrick {
    private String name;
    private int age;

    Monkey(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void makeSound() {
        System.out.println("The monkey " + name + " is " + age + " years old and he makes a sound");
    }

    @Override
    public void eat() {
        System.out.println("The monkey " + name + " is " + age + " years old and he is eating");
    }

    @Override
    public void performTrick() {
        System.out.println("The monkey " + name + " is " + age + " years old and he is making a trick");
    }
}
