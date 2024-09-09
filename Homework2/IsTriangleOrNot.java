//Որպես ծրագրի մուտք ստանում եք 3 հատ ամբողջ թիվ,
// որոնք իրանցից պետքա ներկայացնեն պոտենցիալ եռանկյան կողմերի երկարություններ։
// Ձեր խնդիրնա ստուգել թե արդյոք էդ թվերով հնարավորա ստանալ եռանկյուն ու տպել համապատասխան տեքստ՝
// տեքստի մեջ նշելով նաև հենց թվերը, հակառակ դեպքում տպել եռանկյուն կառուցելու անհնարինության մասին տեքստ՝
// էլի թվերը նշելով։

package Homework2;

import java.util.Scanner;

public class IsTriangleOrNot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter positive integer values for triangle sides");
        int sideA = scanner.nextInt();
        int sideB = scanner.nextInt();
        int sideC = scanner.nextInt();
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            System.out.println("Triangle side length should be positive number");
            System.exit(6);
        }
        if (sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA) {
            System.out.println("It is possible to make a triangle with sides " + sideA + "," + sideB + " and " + sideC);
        } else {
            System.out.println("It is not possible to make a triangle with sides " + sideA + "," + sideB + " and " + sideC);
        }
    }
}
