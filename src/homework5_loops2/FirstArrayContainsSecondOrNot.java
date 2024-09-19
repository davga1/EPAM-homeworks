//Ենթադրենք ունենք 2 հատ զանգված տարբեր չափերով։ Ենթադրվումա, որ
//arr2.length < arr1.length ու arr2.length > 1
//2 զանգվածների մեջ էլ չկրկնվող տարրեր են։ Էս պայմանը նախօրոք պետք չի վալիդացիա անել
//Դուք պետքա ստուգեք, թե արդյոք 2-րդ զանգվածը պարունակվումա առաջինի մեջ թե չէ ու տպեք համապատասխան հաղորդագրություն։
//Օրինակ 1: Input - arr1 [5, 7, 8, 0, -2, 4], arr2 [8, 0, -2] Output - true։
//Օրինակ 2: Input - arr1 [9, 1, -3, 4, 7], arr2 [1, -3, 8, 7] Output - false:

package homework5_loops2;

import java.util.Arrays;
import java.util.Scanner;

public class FirstArrayContainsSecondOrNot {
    public static void main(String[] args) {
        boolean containsSecondArray = true;
        Scanner scanner = new Scanner(System.in);
        int length1;
        do {
            System.out.println("Set length for first array, only positive number");
            length1 = scanner.nextInt();
        } while (length1 < 1);
        int length2;
        do {
            System.out.println("Set length for second array, only positive number and less than first");
            length2 = scanner.nextInt();
        } while (length2 > length1 || length2 < 1);

        int[] array1 = new int[length1]; //create arrays with given lengths
        int[] array2 = new int[length2];
        for (int i = 0; i < array1.length; i++) { //set elements for first array
            System.out.println("Set an element for first array's index " + i);
            array1[i] = scanner.nextInt();
        }
        for (int i = 0; i < array2.length; i++) { //set elements for second array
            System.out.println("Set an element for second array's index " + i);
            array2[i] = scanner.nextInt();
        }
        System.out.println("First array:" + Arrays.toString(array1));
        System.out.println("Second array:" + Arrays.toString(array2));
        //SOLUTION

        int firstIndex = -1;
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                if (array2[i] == array1[j]) {
                    firstIndex = j;
                    break;
                }
            }
            if (firstIndex >= 0) {
                if (firstIndex + array2.length - 1 >= array1.length) {
                    containsSecondArray = false;
                } else {
                    for (int k = 0; k < array2.length; k++) {
                        if (array1[k + firstIndex] != array2[k]) {
                            containsSecondArray = false;
                            break;
                        }
                    }
                }
                break;
            }
        }
        if (firstIndex == -1) {
            containsSecondArray = false;
        }
        System.out.println(containsSecondArray);
    }
}