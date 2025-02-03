package homework21.points;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    //Գրեք մի հատ մեթոդ, որը կունենա մի պարամետր, ու որին որպես արգումենտ հնարավոր կլինի փոխանցել նախորդ խնդրում սարքված map-երը,
    // ու որը հետ կվերադարձնի դրանց key ու value-ները տեղերով փոխած map-եր։
    // Հետո պետքա տպել էդ map-երն ու վստահ լինել, որ ամեն ինչ ճիշտա արվել։
    public static Map<String, Point> swapMaps(Map<Point, String> map) {
        Map<String, Point> temp = new HashMap<>();
        for (Map.Entry<Point, String> mapValue : map.entrySet()) {
            temp.put(mapValue.getValue(), mapValue.getKey());
        }
        return temp;
    }

    public static void main(String[] args) {

        HashMap<Point, String> hashMap = new HashMap<>();
        hashMap.put(Points.p1, "Davit");
        hashMap.put(Points.p2, "Andranik");
        hashMap.put(Points.p3, "Sam");
        hashMap.put(Points.p4, "Gegham");
        hashMap.put(Points.p6, "Arnie");
        TreeMap<Point, String> treeMap = new TreeMap<>(hashMap);
        System.out.println(hashMap);
        System.out.println("----------------------------");
        System.out.println(treeMap);
        System.out.println("----------------------------");
        System.out.println(swapMaps(treeMap));
    }
}
