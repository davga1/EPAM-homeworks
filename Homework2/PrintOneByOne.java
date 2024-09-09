//Ենթադրենք ունենք քառանիշ թիվ, որը ստանումա ծրագիրը որպես մուտք։
//Պետքա գրեք ծրագիր, որը կստանա ու կտպի տվյալ թվի բոլոր թվանշանները։
//Ծրագիրը պետքա աշխատի ցանկացած քառանիշ թվի համար։

package Homework2;

import java.util.Scanner;

public class PrintOneByOne {
    public static void main(String[] args) {
        boolean isNegative = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number from 1000 to 9999");
        int number = scanner.nextInt();
        if (number < 0) {
            isNegative = true;
        }
        if (number >= 1000 && number <= 9999 || number >= -9999 && number <= -1000) {
            if (isNegative) {
                System.out.println("Number one:" + ((number / 1000) * -1) + "\nNumber two:" + ((number / 100 % 10) * -1) + "\nNumber three:" + ((number / 10 % 10) * -1) + "\nNumber four:" + ((number % 10) * -1));
            } else {
                System.out.println("Number one:" + number / 1000 + "\nNumber two:" + number / 100 % 10 + "\nNumber three:" + number / 10 % 10 + "\nNumber four:" + number % 10);
            }
        } else {
            System.out.println("Wrong number");
            System.exit(1);
        }
    }
}