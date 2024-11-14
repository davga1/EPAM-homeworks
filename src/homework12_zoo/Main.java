//Create Zoo Management System
//Create classes Animal Lion, Elephant, and Monkey with properties like name and age. Define makeSound() and eat().
//Create a method performTrick(). Have only  Monkey and Elephant
//Write a main method where they create Arrays of Animal objects
//Iterate over the list, calling makeSound(), eat(), and performTrick()

package homework12_zoo;

public class Main {
    public static void main(String[] args) {
        Lion a = new Lion("afsafasf", 2);
        Animal[] b = {new Lion("sadasd", 321), a, new Monkey("e", 2), new Elephant("bnm", 5)};
        for (Animal animal : b) {
            animal.makeSound();
            animal.eat();
            animal.performTrick();
            System.out.println("-----------------------------");
        }
    }
}
