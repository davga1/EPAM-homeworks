//Ունեք ֆիքսված n չափանի ամբողջ թվերի զանգված (այլ կերպ զանգվածին անվնանում են մասիվ)։
//n-ը որպես ինփութ ծրագիրը ստանումա command line-ից, ու կարա մաքսիմումը լինի 8 չափի։
// Դրանից հետո պետքա ներմուծեք 2 թիվ` a ու b, որոնցից փոքրի արժեքը պետքա տաք մասիվի մեջտեղից
// (երկարության կեսը՝ ամբողջ թվով) անմիջապես ձախ գտնվող անդամին, իսկ մեծը՝ մեջտեղից անմիջապես աջ գտնվող անդամին։

package homework3_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ChangeTwoNumbersInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size for your array");
        int[] array = new int[scanner.nextInt()];
        if (array.length > 8 || array.length < 3) {
            System.out.println("Array length cannot be less than 3 and more than 8");
            System.exit(8);
        }
        System.out.println("Enter two integer numbers");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a < b) {
            array[array.length / 2 - 1] = a;
            array[array.length / 2 + 1] = b;
        } else {
            array[array.length / 2 - 1] = b;
            array[array.length / 2 + 1] = a;
        }
        System.out.println(Arrays.toString(array));
    }
}