//Ունեք ֆիքսված n չափանի ամբողջ թվերի զանգված։
// n-ը որպես input ծրագիրը ստանումա command line-ից, դրանից հետո պետքա ներմուծեք 2 թիվ` a ու b։
// էս անգամ պետքա 2-րդ զանգվածի մեջ գցեք առաջին զանգվածի a-րդ ինդեքսից b-րդ ինդեքս ընկած բոլոր էլեմենտները։
// Պետքա 2-րդ զագնվածում վերագրումը սկսեք առաջին էլեմենտից սկսած (այսինքն 0-րդ)
//100% վստահ եմ որ սրա վրայով քոմմենթ ես գրելու, դե բայց ամեն դեպքում
package homework4_loops;

import java.util.Arrays;
import java.util.Scanner;

public class CreateNewArrayFromGivenOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length;
        do {
            System.out.println("Enter an integer number to create an array(only positive numbers)");
            length = scanner.nextInt();
        } while (length < 0);
        int[] firstArray = new int[length];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = i;
        }
        System.out.println("Enter two numbers");
        int a = scanner.nextInt(), b = scanner.nextInt();
        while (a == b) {// don't want to use System.exit here
            System.out.println("There is no number between " + a + " and " + b + ", try again");
            a = scanner.nextInt();
            b = scanner.nextInt();
        }
        while (a > firstArray.length || b > firstArray.length) {
            System.out.println("You can't pick a number which is higher than the created array's length");
            a = scanner.nextInt();
            b = scanner.nextInt();

        }

        int[] secondArray = new int[a - b < 0 ? b - a - 1 : a - b - 1]; // if I subtract only a- b, e.g. for numbers 2 and 5, later I will get an array [3,4,5], so I decided to do a - b - 1 to get an array [3,4] without using a and b
        if (a < b) {
            for (int i = 0; i < b - a - 1; i++) {
                secondArray[i] = firstArray[i + a + 1];
            }
        } else {
            for (int i = 0; i < a - b - 1; i++) {
                secondArray[i] = firstArray[i + b + 1];
            }
        }
        System.out.println("Between " + (a < b ? a : b) + " and " + (a < b ? b : a) + " are these numbers:" + Arrays.toString(secondArray));
    }
}