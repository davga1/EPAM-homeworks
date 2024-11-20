package homework12_zoo;

public class Lion extends Animal {
    Lion(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("The lion " + super.getName() + " is " + super.getAge() + " years old and he makes a sound");
    }

    @Override
    public void eat() {
        System.out.println("The lion " + super.getName() + " is " + super.getAge() + " years old and he is eating");
    }
}
