//Գրեք ծրագիր, որը կընդունի որպես input ցանկացած անգլերեն փոքրատառ ու որպես արդյունք կտպի դրա մեծատառը։

package Homework1;
import java.util.Scanner;
public class Return_Uppercase_Letter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an english letter");
        char inputCharacter = scanner.next().charAt(0);
        System.out.println( "Uppercase " + inputCharacter + " is " +(char)(inputCharacter - 32));
    }
}
