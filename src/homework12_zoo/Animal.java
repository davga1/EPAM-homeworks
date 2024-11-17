package homework12_zoo;

abstract class Animal {
    private String name;
    private int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Animal is making sound");
    }

    public void eat() {
        System.out.println("Animal is eating");
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
