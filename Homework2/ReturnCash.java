//Պատկերացրեք, սենց իրադրություն.
// Կա ինչ-որ ժամանցային վայր,
// որտեղ մուտքի գումարը 5000 դրամա ոչ vip հաճախորդների համար ու տարիքի մինիմալ սահմանափակումը 16 տարեկաննա.
// հակառակ դեպքում ժամանցային վայր մուտք չկա ու ծրագիրը դադարումա աշխատանքը։
// Հաճախորդի տարիքն ու vip հաճախորդ լինելու ճիշտ կամ սխալ լինելը մուտքագրվում են որպես input։
// Հաջորդ քայլը պատվեր ձևակերպելնա. ձևակերպված պատվերի գումարը պետքա մուտքագրվի Ձեր ծրագրում ու զեղչվի 15%-ով,
// եթե հաճախորդը vip-ա։
// Ծրագրի վերջում տպեք, թե տվյալ հաճախորդը ընդհանուր ինչքան գումարա ծախսել տվյալ ժամանցային վայր մտնելուց հետո։

package Homework2;

import java.util.Scanner;

public class ReturnCash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age");
        int age = scanner.nextInt();
        if (age < 16) {
            System.out.println("Should be at least 16 years old to go in");
            System.exit(6);
        }
        System.out.println("Are you VIP person?");
        boolean isVip = scanner.nextBoolean();
        System.out.println("How much money did you spend?");
        int moneySpent = scanner.nextInt();
        if(moneySpent <= 0){
            System.out.println("Money spent cannot be negative number");
            System.exit(2);
        }
        int sum;
        if (isVip) {
            sum = moneySpent - ((moneySpent * 15) / 100);
            System.out.print("As a VIP person, you have 15% discount, your discount is (" + moneySpent + " * 15) / 100 = " + ((moneySpent * 15) / 100) + ", and your ");
        } else {
            System.out.print("You are not a VIP person, you have to pay additional 5000 to go in, your ");
            sum = moneySpent + 5000;
        }
        System.out.println("final sum is " + sum);
    }
}
