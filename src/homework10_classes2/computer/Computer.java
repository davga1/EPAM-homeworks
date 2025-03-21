//Computer կլաս եք սարքում, որի մեջ ամեն հատի համար պետքա գեներացվի իրա id-ն։
//Ամեն id-ն մյուսից պետքա 1-ով մեծ լինի։ Այսինքն ամեն հաջորդ ստեղծված կոմպի id-ն նախորդին գումարած 1-նա։
//Ձեր Computer կլասը կարա ունենա տարբեր կոնստրուկտորներ օբյեկտ կառուցելու համար,
//հիշողության մաքսիմում սահմանափակումը 2 TB-ա, իսկ RAM-ինը՝ 64 GB։
//Ունեցեք Ձեր կլասի մեջ նաև static մեթոդ generateMegaComputer, որը սարքելուց տվյալ սահմանափակումները չեն գործում։
//Ձեր գրած կլասը պրակտիկ այլ կլասի մեջ կօգտագործեք, որպեսզի վստահ լինեք, որ ճիշտ եք գրել։


package homework10_classes2.computer;

public class Computer {
    static int ID;
    private int memory;
    private int RAM;

    public Computer(int memory, int RAM) {
        if (memory <= 256) {
            System.out.println("Computer memory should be at least 256GB");
            memory = 256;
        } else if (memory > 2000) {
            System.out.println("Maximum 2 TB(2000GB)");
            memory = 2000;
        }
        setMemory(memory);
        if (RAM < 2) {
            System.out.println("Computer RAM should be at least 2GB");
            RAM = 2;
        } else if (RAM > 64) {
            System.out.println("Maximum 64GB");
            RAM = 64;
        }
        setRAM(RAM);
    }

    public int getId() {
        return ID++;
    }

    public int getMemory() {
        return memory;
    }

    public int getRAM() {
        return RAM;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    static Computer generateMegaComputer(Computer computer, int memory, int RAM) {
        computer.setMemory(memory);
        computer.setRAM(RAM);
        return computer;
    }
}
