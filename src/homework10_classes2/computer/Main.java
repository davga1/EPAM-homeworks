package homework10_classes2.computer;

public class Main {
    public static void main(String[] args) {
        Computer a = new Computer(15948651, 25);
        System.out.println("Id:" + a.getId());
        System.out.println("Memory:" + a.getMemory());
        System.out.println("RAM:" + a.getRAM());
        System.out.println("--------------------");
        Computer b = new Computer(0, 44);
        System.out.println("Id:" + b.getId());
        System.out.println("Memory:" + b.getMemory());
        System.out.println("RAM:" + b.getRAM());
        System.out.println("--------------------");
        Computer c = new Computer(400, 25);
        System.out.println("Id:" + c.getId());
        System.out.println("Memory:" + c.getMemory());
        System.out.println("RAM:" + c.getRAM());
        System.out.println("--------------------");
        Computer d = new Computer(44444, 55555);
        System.out.println("Id:" + d.getId());
        System.out.println("Memory:" + d.getMemory());
        System.out.println("RAM:" + d.getRAM());
        System.out.println("--------------------");
        Computer e = Computer.generateMegaComputer(d, 555555, 666666);
        System.out.println("Id:" + e.getId());
        System.out.println("Memory:" + e.getMemory());
        System.out.println("RAM:" + e.getRAM());
    }
}