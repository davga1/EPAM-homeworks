//Ենթադրենք ունեք StudentGrades օբյեկտ։
//Էդ կլասն ունի մի շարք փռոփերթիներ՝ mathKnowledge, physicsKnowledge, historyKnowledge, ու մեկ էլ ուսանողի անունը՝ name։
//Պետքա սարքել տվյալ էդ օբյեկտները, որոնց տվյալ փռոփերթիները տրվում են կոնստրուկտոերից ու ավելացնել դրանք ArrayList-ի մեջ։
//Collections-ի մեջ սենց ստատիկ մեթոդ կա՝ sort։ Որն ընդունումա List. (List-ը Ձեր թեմայի մեջա, պետքա արդեն կարդաք, հասկանաք, թե ինչա դա)։
//Պետքա փոխանցեք Ձեր սարքած ArrayList-ը էդ մեթոդին` Collections.sort(arrayList)։
//Պետքա նենց անեք, որ էդ ծրագիրն աշխատի խելամիտ լուծմամբ։

package homework18.students;

public class StudentGrades implements Comparable<StudentGrades> {
    private final String name;
    private final int mathKnowledge;
    private final int physicsKnowledge;
    private final int historyKnowledge;

    StudentGrades(String name, int mathKnowledge, int physicsKnowledge, int historyKnowledge) {
        this.name = name;
        this.mathKnowledge = mathKnowledge;
        this.physicsKnowledge = physicsKnowledge;
        this.historyKnowledge = historyKnowledge;
    }

    public String getName() {
        return name;
    }

    public int getHistoryKnowledge() {
        return historyKnowledge;
    }

    public int getMathKnowledge() {
        return mathKnowledge;
    }

    public int getPhysicsKnowledge() {
        return physicsKnowledge;
    }

    @Override
    public String toString() {
        return "Name:" + getName() + ", math knowledge:" + getMathKnowledge() + ", history knowledge:" + getHistoryKnowledge() + ", physics knowledge:" + getPhysicsKnowledge();
    }

    // if object's name's first letter's char value is more than second object's - changes these objects with each-other (Mike-M, Archie-A, M>A => Mike,Archie-> Archie,Mike)
    @Override
    public int compareTo(StudentGrades o) {
        if (getName().charAt(0) > o.getName().charAt(0)) return 1;
        if (getName().charAt(0) < o.getName().charAt(0)) return -1;
        return 0;
    }
}
