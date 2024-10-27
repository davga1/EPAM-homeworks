//Ուրեմն պատկերացրեք, որ ունեք մի քանի շինություններ։ Կա սովորական շենք` Building, ու կան նաև դպրոցներ ու հիվանդանոցներ։
//Սովորական շենքն ունի ջրահեռացման համակարգ, քաշած էլեկտրականություն, և այլն։
//Դուք հնարավորություն ունեք տեսնելու թե ինչ վոլտաժով էլեկտրականությունա քաշած ու քանի ելք ունեն ջրահեռացման համակարգերը։
//Դրանք շենքի օբյեկտը կառուցելուց արդեն հայտնիա դառնում։

package homework11_buildings_dummyapp.buildings;

public class Building {
    private final int drainageSystemOutlets;
    private final int voltageOfElectricity;


    Building(int drainageSystemOutlets, int voltageOfElectricity) { //create new Building
        this.drainageSystemOutlets = drainageSystemOutlets;
        this.voltageOfElectricity = voltageOfElectricity;
    }

    Building(Building building) { // Copy from existing one
        drainageSystemOutlets = building.drainageSystemOutlets;
        voltageOfElectricity = building.voltageOfElectricity;

    }

    Building() {
        drainageSystemOutlets = 1;
        voltageOfElectricity = 220;
    }

    public int getDrainageSystemOutlets() {
        return drainageSystemOutlets;
    }

    public int getVoltageOfElectricity() {
        return voltageOfElectricity;
    }

    public void getElectricityAndDrainage(Building building) {
        System.out.println("Voltage of electricity:" + building.getVoltageOfElectricity() + "\nOutlets of drainage sysem:" + building.getDrainageSystemOutlets());
    }

}
