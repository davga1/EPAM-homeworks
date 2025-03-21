//Մի հատ էլ պարզ խնդիր. պիտի գրեք մեթոդ, որը կստանաս ամբողջ թվերի array ու ևս մեկ՝ array-ի տիպն ունեցող պարամետր։
//Ձեր մեթոդը պետքա վերադարձնի true, եթե էդ թիվը պարունակվումա array-ի մեջ, ու false, եթե չի պարունակվում։
package homework6_methods;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayContainsGivenNumberOrNot {

    static boolean containsGivenNumber(int[] array, int number) {
        for (int x : array) {
            if (x == number) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length;
        do {
            System.out.println("Set length for your array");
            length = scanner.nextInt();
        } while (length <= 0);
        int[] array = new int[length];
        System.out.println("Enter a numbers for your array: 1 2 3 4 etc.");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Enter a number to check");
        int number = scanner.nextInt();
        System.out.println(containsGivenNumber(array, number));
    }
}
