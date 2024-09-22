//Գրել ծրագիր, որը կգտնի տվյալ զանգվածում ամենաերկար աճող հաջորդականության երկարությունը։
//Օրինակ1: [3, 4, 5, 2, 7, 8, 9], output: 3, որովհետև ամենաերկար հաջորդականությունը 2,7,8,9-նա, որի երկարությունը 3-ա
//Օրինակ2: [5,9, -2, -3, 7], output: 1, որովհետև 5,9-ը ամենաերկար հաջորդականություննա։
//Էս երկարութոյունը մի շփոթեք array.length-ի հետ ու ձեր մոտ թող սխալ տպավորություն չթողի,
//որտև սրա մեջ գոնե 2 անդամ պետք են որ հաջորդականությունը երկարություն ունենա ընդհանրապես։

package homework5_loops2;

import java.util.Scanner;

public class BiggestAscendingSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength;
        do {
            System.out.println("Set array length");
            arrayLength = scanner.nextInt();
        } while (arrayLength < 2);
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Set an element for array's index[" + i + "]");
            array[i] = scanner.nextInt();
        }
        // SOLUTION
        int count = 0;
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                temp++;
            } else {
                count = count <= temp ? temp : count;
                temp = 0;
            }
        }
        count = count <= temp ? temp : count;
        System.out.println(count);
    }
}
