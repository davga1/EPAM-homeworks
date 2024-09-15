//Ենթադրենք ունենք քառանիշ թիվ, որը ստանումա ծրագիրը որպես մուտք։
//Պետքա գրեք ծրագիր, որը կստանա ու կտպի տվյալ թվի բոլոր թվանշանները։
//Ծրագիրը պետքա աշխատի ցանկացած քառանիշ թվի համար։

package homework1;

import java.util.Scanner;

public class PrintOneByOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number from 1000 to 9999");
        int number = scanner.nextInt();
        if (number < 1000 || number > 9999) {
            System.out.println("Wrong number");
            System.exit(2);
        } else {
            System.out.println("Number one:" + number % 10);
            number = number / 10;
            System.out.println("Number two:" + number % 10);
            number = number / 10;
            System.out.println("Number three:" + number % 10);
            number = number / 10;
            System.out.println("Number four:" + number % 10);
        }
    }
}