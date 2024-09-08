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
        if(number < 0){
            number = number * -1;
        }
        if (number < 1000 || number > 9999) {
            System.out.println("Wrong number");
            System.exit(1);
        } else {
            System.out.println("Number one:" + number / 1000);
            System.out.println("Number two:" + number /100 % 10);
            System.out.println("Number three:" + number / 10 % 10);
            System.out.println("Number four:" + number % 10);
        }
    }
}