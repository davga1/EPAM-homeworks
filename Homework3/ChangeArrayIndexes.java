//Ներմուծում եք n ամբողջ թիվը, որին համապատասխան էլ պետքա սարքեք նոր զանգված։
// Ներմուծում եք նաև թիվ՝ a։ Էս թիվը իրանից իրականում պետքա ներկայացնի տվյալ մասիվի անդամի ինդեքս։
// Խնդիրը կայանումա նրանում, որ պետքա էդ ինդեքսից սկսած հաջորդ 3 անդամները ստանան հենց իրանց ինդեքսների արժեքները։
// Օրինակ եթե 5-ա ներմուծվել, պետքա 6-րդի արժեքը լինի 6 7-րդինը 7, ու 8-րդինը՝ 8։
// Եթե ներմուծված տվյալների պատճառով հնարավոր չի խնդիրը կատարել, ուրեմն ծրագիրը պետքա համապատասխան հաղորդագրությամբ դադարացնի աշխատանքը։

package Homework3;

import java.util.Arrays;
import java.util.Scanner;

public class ChangeArrayIndexes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your array length");
        int length = scanner.nextInt();
        if (length < 0) {
            System.out.println("Array length cannot be negative");
            System.exit(666);
        }
        int[] array = new int[length];
        System.out.println("Enter a number");
        int number = scanner.nextInt();
        if (number + 3 >= array.length) {
            System.out.println("Provided number is greater than it can be"); // I don't know what can I write here, any ideas?
            System.exit(6);
        }
        array[number + 1] = number + 1;
        array[number + 2] = number + 2;
        array[number + 3] = number + 3;
        System.out.println(Arrays.toString(array));
    }
}
