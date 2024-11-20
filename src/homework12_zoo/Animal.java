package homework12_zoo;

abstract class Animal {
    private String name;
    private int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract void makeSound();

    abstract void eat();


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
