//Ունեք ցանկացած չափի դրական ամողջ թիվ։ Տպեք տվյալ թվի բոլոր թվանշանները՝ ձախից աջ։
//Ձեր սկզբնական թիվը կարաք փոփոխեք ոնց ուզեք։

package Homework4;

import java.util.Scanner;

public class PrintOneByOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.println("Enter a positive number");
            number = scanner.nextInt();
        } while (number <= 0);
        int divisor = 1;
        while (number / divisor >= 10) {
            divisor *= 10;
        }
        while (divisor > 0) {
            System.out.println(number / divisor);
            number %= divisor;
            divisor /= 10;
        }
    }
}