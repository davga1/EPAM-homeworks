//Սարքում եք մի հատ ArrayList, մեջը լցնում մի գլուխ Integer-ներ։
//Ձեզանից պահանջվումա գտնել տվյալ Arraylist-ում էլեմենտների կրկնությունների քանակը։ Լուծեք ոնց ուզում եք, չկա սահմանափակում։
package homework21.arraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetElementsCount {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 2, 3, 4, 1, 11));
        HashMap<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = arrayList.size() - 1; j >= 0; j--) {
                if (arrayList.get(i).equals(arrayList.get(j))) {
                    counter++;
                    map.put(arrayList.get(i), counter);
                }
            }
            counter = 0;
        }
        System.out.println(map);
    }
}
