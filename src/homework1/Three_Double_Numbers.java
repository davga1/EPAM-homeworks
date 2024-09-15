//Ենթադրենք ունեք 3 հատ double թիվ։ Գրել ծրագիր, որը
//գումարումա էդ 3 թվերը ու տպումա արդյունքի ամբողջ մասը
//տպումա էդ 3 թվերի գումարի միայն տասնորդական մասը ( օրինակ՝ input 62.547, output -> 547)
//տպումա էդ 3 թվերի ամբողջ մասերի գումարը

package homework1;

import java.util.Scanner;

public class Three_Double_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter double value for first number");
        double double1 = scanner.nextDouble();
        System.out.println("Enter double value for second number");
        double double2 = scanner.nextDouble();
        System.out.println("Enter double value for third number");
        double double3 = scanner.nextDouble();

        double sum = double1 + double2 + double3;
        System.out.println("TASK1:" + (int) sum + "\nTASK2:" + sum % 1 + "\nTASK3:" + ((int) double1 + (int) double2 + (int) double3));
    }
}