//Ունեք double[] array. մեջը խառը դրական ու բացասական թվեր։ Ձեր խնդիրը հետևյալումա`
// սկսում եք իտերացիան առաջին էլեմենտից ու
//եթե հերթական էլեմենտը դրական թիվա, իտերացիան մի քայլով եք առաջ տանում
//եթե կանգնում եք բացասական թվի վրա, ուրեմն իտերացիան 2 քայլով եք առաջ տանում
//Եթե կանգնում եք 0-ի վրա, պետքա տեղում դուրս գաք ցիկլից
//Վերջում պետքա տպեք բոլոր էն թվերի գումարը, որոնց վրայով անցել եք իտերացիաների ընթացքում։

package Homework4;

import java.util.Scanner;

public class GetSumOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length;
        do {
            System.out.println("Array length should be at least 1");
            length = scanner.nextInt();
        } while (length <= 0);
        double[] array = new double[length];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Assign a number for given array's index " + i);
            array[i] = scanner.nextDouble();
        }
        // All lines that I wrote before were just to create an array with elements, now I will write the solution
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (array[i] < 0) {
                i += 1;
            } else if (array[i] == 0) {
                break;
            }
        }
        System.out.println(sum);
    }
}