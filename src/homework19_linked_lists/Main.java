//Ստեղծում ենք LinkedList, որի մեջ պահվում են պետությունները։ Լիստի մեջ կարան լինեն կրկնվող պետություններ։
//Ձեր խնդիրնա գտնել ու ջնջել դուպլիկատները, թողնելով միայն ունիկալ պետությունների ցանկ։
//Թե որոնք են պետությունը իդենտիֆիկացնող հատկանիշները, էդ դուք մտածեք, փորձեք հնարավորինս ռեալիստիկ բան մտածել։
//Խնդիրը լուծելուց չօգտագործել ուրիշ դատա ստրուկտուրաներ, որոնք մենք չենք անցել։
//Նաև պետք չի օգտագործել ինչ-որ built-in լուծում պարունակող պատրաստի կլասսներ կամ մեթոդներ։
//Պետքա ալգորիթմիկ լուծում տալ։
package homework19_linked_lists;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Nation> nations = new LinkedList<>();
        nations.add(NationsList.Armenia);
        nations.add(NationsList.Belgium);
        nations.add(NationsList.Armenia);
        nations.add(NationsList.Belgium);
        nations.add(NationsList.Canada);
        nations.add(NationsList.Canada);
        nations.add(NationsList.Japan);
        nations.add(NationsList.France);
        nations.add(NationsList.Australia);
        nations.add(NationsList.India);
        for (int i = 0; i < nations.size(); i++) {
            for (int j = i + 1; j < nations.size(); j++) {
                if (nations.get(i).getCapital().equals(nations.get(j).getCapital())) {
                    nations.remove(j);
                    j--;
                }
            }
        }
        System.out.println(nations);
    }
}
