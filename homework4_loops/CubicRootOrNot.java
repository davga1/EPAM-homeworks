//Ունեք ցանկացած ամբողջ թիվ, որը ներմուծում եք։
// Ձեր խնդիրնա պարզել, թե արդյոք տվյալ թիվը հանդիսանումա մեկ այլ ամբողջ թվի խորանարդ։
// Եթե հա, տպեք էդ թիվը, հակառակ դեպքում զուտ հաղորդագրություն տպեք,
// որ ձեր ներմուծածը չի հանդիսանում որևէ ամբողջ թվի խորանարդ.

package homework4_loops;

import java.util.Scanner;

public class CubicRootOrNot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        boolean isTrue = false;
        for (int i = 1; i < number / 3; i++) {
            if (i * i * i == number) {
                System.out.println("cubic root of " + number + " is " + i);
                isTrue = true;
                break;
            }
        }
        if (!isTrue) {
            System.out.println(number + " does not have cubic root");
        }
    }
}