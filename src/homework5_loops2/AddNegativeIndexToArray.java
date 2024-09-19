//Ունեք խառը թվերով լցված զանգված։
// Զանգվածի առաջին բացասական թվից հետո պետքա insert անեք նոր թիվ՝ տվյալ բացասական էլեմենտի ինդեքսը։
// Կրկնում եմ՝ insert, ու ոչ թե replace. Դրանից կախված թե ոնց պետքա հիշողության մեջ array վերցնեք, անհրաժեշտության դեպքում ոնց փոխեք տվյալ անունով array-ի չափը և այլն, ձեր գործնա։
// Օրինակ input - [4, 7, 9, -2, 1, -1], output [4, 7, 9, -2, 3, 1, 5]:
// Կամ input [4, 0, 6, 12], output - [4, 0, 6, 12]

package homework5_loops2;

import java.util.Arrays;
import java.util.Scanner;

public class AddNegativeIndexToArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // creating array with elements
        int length;
        do {
            System.out.println("Enter length for your array");
            length = scanner.nextInt();
        } while (length <= 0);
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter a value for array's index N" + i);
            array[i] = scanner.nextInt();
        }
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            int[] newArray = new int[array.length + 1];
            System.out.println("INDEX:" + index);
            newArray[index + 1] = index;
            for (int i = 0; i < newArray.length; i++) {
                if (i == index + 1) continue;
                newArray[i] = i > index ? array[i - 1] : array[i];
            }
            array = newArray;
        }
        System.out.println(Arrays.toString(array));
    }
}