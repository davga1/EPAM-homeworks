//Վերցնում եք ամբողջ թվերի զանգված։
// Մի ցիկլով գտնում եք տվյալ զանգվածի միջի մինիմում ու մաքսիմում թվերը։
// Դիտարկում եք տարբեր corner case-եր նաև, որպեսզի վստահ լինեք, որ ճիշտա աշխատում։
// Օրինակ եթե array-ի մեջ բոլոր թվերը նույնն են, ուրեմն ձեր մինիմումն ու մաքսիմումը պիտի համընկնեն։

package homework5_loops2;
import java.util.Scanner;

public class GetMinAndMaxFromArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // creating array with elements
        int length;
        do {
            System.out.println("Enter length for your array");
            length = scanner.nextInt();
        } while (length <= 0);
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter a value for array's index N" + i);
            array[i] = scanner.nextInt();
        }

        int min = array[0];
        int max = array[array.length - 1];
        for(int i = 0; i < array.length;i++){
            min = min > array[i] ? array[i] : min;
            max = max < array[i] ? array[i] : max;
        }
        System.out.println("MIN:" + min);
        System.out.println("MAX:" + max);
    }
}