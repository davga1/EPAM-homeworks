package homework12_zoo;

public class Monkey extends Animal implements PerformTrick {
    Monkey(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("The monkey " + super.getName() + " is " + super.getAge() + " years old and he makes a sound");
    }

    @Override
    public void eat() {
        System.out.println("The monkey " + super.getName() + " is " + super.getAge() + " years old and he is eating");
    }

    @Override
    public void performTrick() {
        System.out.println("The monkey " + super.getName() + " is " + super.getAge() + " years old and he is making a trick");
    }
}
