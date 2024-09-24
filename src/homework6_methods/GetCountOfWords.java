//Ունեք սովորական String փոփոխական, որի մեջ անգլերեն տառերով տեքստա գրած պրոբելներով։
//Դուք պիտի գրեք մեթոդ, որը կստանա տվյալ String-ը որպես պարամետր ու կվերադարձնի String-ում բառերի քանակը։
//Բառ համարվումա ցանկացած մինիմում >=1 տառ(եր)ի հաջորդականությունը
//Պրոբելների քանակը կարա լինի 1-ից ավել տեքստի մեջ ցանկացած 2 բառի արանքում

package homework6_methods;

import java.util.Scanner;

public class GetCountOfWords {
    static int getLength(String word) {
        int count = 0;
        char firstLetter = ' ';
        char lastLetter = ' ';
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) != ' ') {
                firstLetter = word.charAt(i);
                if (word.charAt(i + 1) != ' ') {
                    firstLetter = word.charAt(i + 1);
                    continue;
                }
                for (int j = i + 1; j < word.length() - 1; j++) {
                    if (word.charAt(j) == ' ' && word.charAt(j + 1) != ' ') {
                        lastLetter = word.charAt(j + 1);
                    }
                }
            }
            if (firstLetter != ' ' && lastLetter != ' ') {
                count++;
                firstLetter = ' ';
                lastLetter = ' ';
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";
        do{
            System.out.println("Enter a text");
            text = scanner.nextLine();
        }while (text.isEmpty());
        System.out.println("You have " + getLength(text) + " words in your sentence");
    }
}
