//Պատկերացրեք ունեք ֆիքսված 5 չափանի մասիվ, մեջը կարաք միանգամից սկզբնարժեքավորեք խառը double թվերով։
// Պետքա ստանաք դրանից մի այլ մասիվ, որը բաղկացած կլինի առաջինի՝ միայն ոչ բացասական թվերից։
// 2-րդ զանգվածի էլեմենտներին վերագրումը պետքա լինի հակառակ հերթականությամբ՝ վերջից սկիզբ։
// Եթե չվերագրված տեղեր մնան 2-րդ զանգվածում, ուրեմն թող լցվեն 0-ով։
// Խնդիրը պետքա աշխատի 5 չափանի մասիվում բացասական ու ոչ բացասական թվերի ցանկացած քանակության դեպքում։

package homework3_arrays;

import java.util.Scanner;

public class TwoArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write 5 numbers for your array");
        double[] array = {scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble()};
        double[] secondArray = new double[5];
        int i = 0;
        if (array[0] >= 0) {
            secondArray[secondArray.length - 1 - i++] = array[0];
        }
        if (array[1] >= 0) {
            secondArray[secondArray.length - 1 - i++] = array[1];
        }
        if (array[2] >= 0) {
            secondArray[secondArray.length - 1 - i++] = array[2];
        }
        if (array[3] >= 0) {
            secondArray[secondArray.length - 1 - i++] = array[3];
        }
        if (array[4] >= 0) {
            secondArray[secondArray.length - 1 - i] = array[4];
        }
        System.out.println("New Array:" + "[" + secondArray[0] + "," + secondArray[1] + "," + secondArray[2] + "," + secondArray[3] + "," + secondArray[4] + "]");
    }
}