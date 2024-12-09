//Որպես տնային գրում եք ռեկուրսիվ ֆունկցիա, որը հաշվում եւ վերադարձնումա թվի երկուական տեսքը։
//Վերադարձվող արժեքի տիպը դուք որոշեք։
//Որպես տարբերակներ կարան լինեն String, Array կամ ցանկացած այլ տարբերակ։

package homework17_recursion;

public class Main {
    static String binary(int number) throws CheckedException {
        if (number < 0) throw new CheckedException("Can convert only positive numbers");
        if (number == 0) {
            return "0";
        }
        if (number == 1) {
            return "1";
        }
        return binary(number / 2) + (number % 2);
    }

    public static void main(String[] args) {
        try{
            System.out.println(binary(-8));
        }catch (CheckedException e){
            System.out.println("Exception:" + e.getMessage());
        }
    }
}
