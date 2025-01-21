//Գրեք Generic մեթոդ, որը կընդունի ցանկացած տեսակի էլեմենտներ պարունակող ArrayList, ու ևս մեկ արգումենտ՝ տվյալ arraylist-ի անդամների տիպի։
//Ձեր մեթոդը պետքա ուղղակի ստուգի, թե արդյոք փոխանցվող էլեմենտը գոյություն ունի տվյալ arraylist-ում։
//Կիրառեք մեթոդը նաև վերը նշված խնդրում Student կլասի օբյեկտների հավաքածուի համար։

package homework18.contains_or_not;

import java.util.ArrayList;

import static homework18.contains_or_not.ContainsOrNot.containsOrNot;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("123");
        a.add("13");
        a.add("12");
        System.out.println(containsOrNot(a, "111"));
    }
}
