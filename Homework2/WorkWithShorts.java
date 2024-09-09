//Գրեք ծրագիր, որը որպես input կստանա 3 հատ short թիվ։
// Պետքա հաշվել էդ թվերի միջին թվաբանականը ու պահել ամբողջ տիպ փոփոխականի մեջ։
// Հետո մուտքային 3 թվերի բացարձակ (այսինքն մոդուլով) արժեքները պետքա գումարեք իրար ու բաժանեք էդ միջին արժեքի վրա,
// վերջում տպեք արդյունքը։

package Homework2;

import java.util.Scanner;

public class WorkWithShorts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first short number");
        short numberA = scanner.nextShort();
        System.out.println("Enter second short number");
        short numberB = scanner.nextShort();
        System.out.println("Enter third short number");
        short numberC = scanner.nextShort();
        int arithmeticMean = (numberA + numberB + numberC) / 3;
        if (arithmeticMean == 0) {
            System.out.println("Cannot divide by zero(" + numberA + " + " + numberB + " + " + numberC + ")/3 = 0");
            System.exit(6);
        }
        if (numberA < 0) {
            numberA *= -1;
        }
        if (numberB < 0) {
            numberB *= -1;
        }
        if (numberC < 0) {
            numberC *= -1;
        }
        int sum = (numberA + numberB + numberC);
        System.out.println("sum:" + sum);
        System.out.println("arithmetic mean:" + arithmeticMean);
        System.out.println("result:" + (sum / arithmeticMean));
    }
}
