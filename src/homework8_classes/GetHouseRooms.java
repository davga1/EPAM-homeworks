package homework8_classes;//Հայտարարում եք homework8_homework8_classes.Home կլասսը, որի մեջ պետքա լինի ինֆորմացիա սենյակների,
// սանհանգույցի ու տան այլ մասերի չափերի մասին։ Ծրագիրը պետքա թույլ տա,
// որ դուք նշելով տան բոլոր մասերի չափերը (ենթադրենք չափման միավորը քառակուսի մետրնա) կառուցեք homework8_homework8_classes.Home class-ի օբյեկտներ։
// Պետքա ունենաք 2-րդ կոնստրուկտոր, որը կընդունի բոլոր չափերը բացի բաղնիք-զուգարանից։
// Եթե փոխանցած չի բաղնիք-զուգարանը, ուրեմն դիֆոլթով կոնկրետ արժեքներ պետքա ընդունեն, թողնում եմ ձեր ճաշակին։
// Եթե փոխանցված չափերից որևէ մեկը <=0, ծրագիրը պետքա համապատասխան հաղորդագրություն տպի ու փակվի։
// main-ի մեջ սարքեք մի քանի օբյեկտներ տարբեր կոնստրուկտորներով ու օգտագործեք, համոզվելու համար որ սաղ ճիշտա։

public class GetHouseRooms {

    static void validateSizes(int... sizes) {
        for (int size : sizes) {
            if (size <= 0) {
                System.out.println("Size cannot be <= 0");
                System.exit(6);
            }
        }
    }

    static String displayHomeInfo(House home) {
        validateSizes(home.livingRoomSize, home.bedroomSize, home.bathroomSize, home.diningRoomSize, home.kitchenSize);
        return "Living room size is " + home.livingRoomSize + "m²,\nKitchen size is " + home.kitchenSize + "m²,\nDining room size is " + home.diningRoomSize + "m²,\nBedroom size is " + home.bedroomSize + "m²,\nBathroom size is " + home.bathroomSize + "m²";
    }

    public static void main(String[] args) {
        House a = new House(15, 10, 10, 10, 10);
        System.out.println(displayHomeInfo(a));
        System.out.println("----------------------------------");
        House b = new House(10, 15, 10, 4);
        System.out.println(displayHomeInfo(b));
        System.out.println("----------------------------------");
        House c = new House(-5, 0, 1, 2, 3);
        System.out.println(displayHomeInfo(c));
    }
}

class House {
    int bathroomSize = 5;
    int bedroomSize;
    int diningRoomSize;
    int livingRoomSize;
    int kitchenSize;

    House(int bathroomLength, int bedroomLength, int diningRoomLength, int livingRoomLength, int kitchenLength) {
        bathroomSize = bathroomLength;
        bedroomSize = bedroomLength;
        diningRoomSize = diningRoomLength;
        livingRoomSize = livingRoomLength;
        kitchenSize = kitchenLength;
    }

    House(int bedroomLength, int diningRoomLength, int livingRoomLength, int kitchenLength) {
        bedroomSize = bedroomLength;
        diningRoomSize = diningRoomLength;
        livingRoomSize = livingRoomLength;
        kitchenSize = kitchenLength;
    }
}