//Սարքեք Teacher կլաս, իրա որոշակի փռոփերթիներով։
//Դա թողնում եմ Ձեզ, դուք ամեն մեկդ որոշեք թե ինչ փռոփերթիներ ունենա Ձեր կլասը։
//Ունեք նաև որոշակի գործակից, որի հիման վրա որոշվումա ուսուցիչների բազային աշխատավարձը։
//Ենթադրենք, էդ K գործակիցը սահմանումա պետությունը,որն ընդհանուրա բոլոր ուսուցիչների համար
//իսկ Ձեր ծրագիրը դա ընդունումա որպես input ու փոխանցումա դա Teacher կլասին ֆիքսելու համար։ Գործակիցը չի կարա փոքր լինի 1-ից։
//Ուսուցչի բազային աշխատավարձը որոշվումա minBaseSalary = K * minSalary բանաձևով,
//ընդ որում MIN_SALARY-ն նույնպես ծրագիրը պետքա ստանա որպես input ու հիշվի Teacher կլասի մեջ։
//Ուսուցիչների բազային աշխատավարձը չպիտի հաշվվի մեթոդներով կամ կոնստրուկտորի մեջ, որևէ ուղիղ կանչով չպիտի դա հաշվարկվի։
//Հաշվարկը կատարող կոդը պետքա աշխատի ավտոմատ կլասի լոդինգի ժամանակ, իսկ թե ոնց կազմակերպեք, սկզբից պետքա կարդալ թեման։
//Հետո ամեն մի ուսուցիչ պետքա ունենա իրան հատուկ W կայֆիցենտը,
//որը օբյեկտը ստեղծելուց պետքա փոխանցվի, որը նույնպես չի կարա փոքր լինի 1-ից։
//Արդեն հենց իրա աշխատավարձի չափը պետքա հաշվարկվի salary = W * minBaseSalary բանաձևով։

package homework10_classes2.teacher;

public class Teacher {

    private static double K;
    private static int MIN_SALARY;
    private static int MIN_BASE_SALARY;


    static {
        updateMinBaseSalary();
    }

    public static void updateMinBaseSalary() {
        MIN_BASE_SALARY = (int) (K * MIN_SALARY);
    }

    private int age;
    private String subject;
    private int salary;
    private double W;
    public Teacher(int age, String subject) {
        setAge(age);
        setSubject(subject);
        switch (subject) {
            case "Mathematics": {
                W = 1.4;
                break;
            }
            case "History": {
                W = 1.25;
                break;
            }
            case "Physics": {
                W = 1.35;
                break;
            }
            case "Literature": {
                W = 1.15;
                break;
            }
            default:
                W = 1;
                break;
        }
        setSalary((int) (W * MIN_BASE_SALARY));
    }

    public int getAge() {
        return age;
    }

    public String getSubject() {
        return subject;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public static double getK() {
        return K;
    }

    public static void setK(double k) {
        K = k;
        updateMinBaseSalary();
    }

    public static void setMinSalary(int minSalary) {
        MIN_SALARY = minSalary;
        updateMinBaseSalary();
    }

    public static int getMinSalary() {
        return MIN_SALARY;
    }

    public double getW() {
        return W;
    }
}