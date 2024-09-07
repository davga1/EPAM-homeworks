//Ունեք 2 input` a և b, որոնք ամբողջ թվեր են։ Պետքա գրել ծրագիր, որը
//կտպի true, եթե a-ն բաժանվումա b-ի վրա առանց մնացորդ
//կտպի false հակառակ դեպքում

package Homework1;

import java.util.Scanner;

public class IsADivisibleByB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number");
        int a = scanner.nextInt();
        System.out.println("Enter second number");
        int b = scanner.nextInt();
        System.out.println(a % b == 0);
    }
}
