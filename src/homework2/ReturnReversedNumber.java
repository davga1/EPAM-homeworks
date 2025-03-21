//Ձեր ծրագիրը պետքա ստանա որպես input եռանիշ դրական թիվ։
// Ձեր խնդիրնա ստանալ տվյալ թվի շրջած տարբերակը և տպել։
// Օրինակ` input - 893, output - 398։
// Դիտարկել տարբեր հնարավոր մուտքային տվյալներ ու եթե շրջելուց անհնարա ստանալ valid եռանիշ թիվ,
// տպել համապատասխան հաղորդագրություն ու ծրագիրը փակել տեղում։
package homework2;

import java.util.Scanner;

public class ReturnReversedNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 3-digit number");
        int number = scanner.nextInt();
        if (number <= 99 || number >= 1000) {
            System.out.println("Provided number contains more or less than 3 digits");
            System.exit(66);
        }
        if (number % 10 == 0) {
            System.out.println("First reversed number is 0, so it can't be valid 3-digit number");
            System.exit(666);
        }
        System.out.println("Input:" + number + "\nOutput:" + (number % 10) + (number / 10 % 10) + (number / 100));

    }
}
