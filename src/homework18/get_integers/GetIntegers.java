//Ունեք մի arraylist, որի մեջ խառը ռացիոնալ թվեր են լցված՝ ամբողջ կամ կոտորակային մասով։
//Ձեր խնդիրնա, պտտվել տվյալ arraylist-ի վրայով,
//առանձնացնել Integer-ներն ու ավելացնել նոր arraylist-ի մեջ, որտեղ հենց պետքա պահվեն միայն ամբողջ թվեր։
package homework18.get_integers;

import java.util.ArrayList;

public class GetIntegers {
    public static void main(String[] args) {
        ArrayList<Number> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(1.2);
        arrayList1.add(1.2);
        arrayList1.add(2);
        arrayList1.add(6);
        ArrayList<Number> arrayList2 = new ArrayList<>();
        for (Number num : arrayList1) {
            if (num.getClass() == Integer.class) {
                arrayList2.add(num);
            }
        }
        System.out.println(arrayList2);
    }
}
