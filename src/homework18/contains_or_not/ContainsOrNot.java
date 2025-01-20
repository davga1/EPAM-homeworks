package homework18.contains_or_not;

import java.util.ArrayList;

public class ContainsOrNot {
    public static <T> Boolean containsOrNot(ArrayList<T> arrayList, T element) {
        return arrayList.contains(element);
    }
}