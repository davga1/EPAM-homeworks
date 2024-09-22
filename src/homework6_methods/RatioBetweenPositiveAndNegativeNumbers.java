//Գրեք մեթոդ, որը կընդունի ամբողջ թվերի զանգված։
//Ձեր խնդիրնա գտնել մեթոդին փոխանցված array-ում դրական ու բացասական թվերի հարաբերակցությունը` positive / negative,
//ու վերադարձնել տվյալ double թիվը։ Եթե չլինեն բացասական թվեր, թող վերադարձնի -1։
package homework6_methods;

import java.util.Scanner;

public class RatioBetweenPositiveAndNegativeNumbers {
    static double ratio(int[] array) {
        int positiveNumbersCounter = 0;
        int negativeNumbersCounter = 0;
        for (int j : array) {
            if (j > 0) {
                positiveNumbersCounter++;
            }
            if (j < 0) {
                negativeNumbersCounter++;
            }
        }
        if (negativeNumbersCounter == 0) {
            return -1;
        }
        return (double) positiveNumbersCounter / negativeNumbersCounter;
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
        System.out.println(ratio(array));
    }
}
