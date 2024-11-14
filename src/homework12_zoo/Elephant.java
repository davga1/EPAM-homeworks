package homework12_zoo;

public class Elephant implements Animal {
    private String name;
    private int age;

    Elephant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void makeSound() {
        System.out.println("The elephant " + name + " is " + age + " years old and he makes a sound");
    }

    @Override
    public void eat() {
        System.out.println("The elephant " + name + " is " + age + " years old and he is eating");
    }

    @Override
    public void performTrick() {
        System.out.println("The elephant " + name + " is " + age + " years old and he is making a trick");
    }
}
