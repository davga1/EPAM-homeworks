package homework12_zoo;

public class Lion implements Animal {
    private String name;
    private int age;

    Lion(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void makeSound() {
        System.out.println("The lion " + name + " is " + age + " years old and he makes a sound");
    }

    @Override
    public void eat() {
        System.out.println("The lion " + name + " is " + age + " years old and he is eating");
    }
}
