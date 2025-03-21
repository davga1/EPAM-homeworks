//Պետքա ներմուծեք n ամբողջ թիվ՝ դրա հիման վրա մասիվ ստանալու համար.
//Եթե n-ը 3-ա, ուրեմն array-ի չափն էլ պետքա լինի 3
//Եթե 4-ա, ուրեմն 4
//Եթե 5-ա, ուրեմն 5
//Եթե 6-ա, կամ 7, ուրեմն չափը պետքա լինի 10
//Մնացած բոլոր դրական թվերի դեպքերում պետքա լինի 15 ու իրա առաջին անդամի արժեքն էլ հենց 15։

package homework3_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayLengthDependingOnInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your array size");
        int length = scanner.nextInt();
        if (length < 0) {
            System.out.println("Only positive numbers");
            System.exit(6);
        }
        int[] array;
        switch (length) {
            case 3, 4, 5: {
                array = new int[length];
                break;
            }
            case 6, 7: {
                array = new int[10];
                break;
            }
            default: {
                array = new int[15];
                array[0] = 15;
            }
        }
        System.out.println("Your array is " + Arrays.toString(array) + "(length is " + array.length + ")");
    }
}