//Ունեք զանգված, որի մեջ կան տարբեր դրական ամբողջ թվեր. հեշտության համար array-ը ուղիղ հայտարարեք ու ինիցալիզացրեք կոդի մեջ։
//Ձեզնից պահանջվումա գրել ծրագիր, որը կստուգի array-ի հերթական անդամի պարզ լինել-չլինելը ու կտպի համապատասխան հաղորդագրություն։
//Յուրաքանչյուր անդամի պարզ լինել-չլինելը պետքա ստուգբի առանձին մեթոդով։
//Նորից եմ շեշտում, յուրաքանչյուր թվի ստուգելը պետքա լինի առանձին մեթոդով, ոչ թե ամբողջ array-ինը։
//Ձեր մեթոդը պետքա վերադարձնի սխալա թե ճիշտ, որ array-ի հերթական թիվը պարզա։

package homework6_methods;

import java.util.Scanner;

public class PrimeNumbersInArray {
    static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) { //primes are integers greater than one with no positive divisors besides one and itself
            if (number % i == 0) return false;
        }
        return number >= 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length;
        do {
            System.out.println("Enter an array size");
            length = scanner.nextInt();
        } while (length < 0);
        int[] array = new int[length];
        System.out.println("Enter elements for your array (to make it shorter just use spase bar after each element instead of taping enter after each element e.g. 1 2 3 4)");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        for (int j : array) {
            System.out.println(j + " is a prime number:" + isPrime(j));
        }
    }
}
