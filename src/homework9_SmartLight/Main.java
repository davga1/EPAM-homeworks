//Create a SmartLight class with private attributes
// isOn (boolean), brightness (0-100), and color (String). Implement getters and setters for each field.
// Add a method toggle() that switches the light on or off.
//Create a RemoteControl class that can interact with a SmartLight object by passing the SmartLight instance as a parameter to its methods.
//1.Add a method resetLight() in RemoteControl that resets the SmartLight attributes to default values (off, brightness 50, color “white”).
//2.Implement a SmartLight getLightStatus() method in the RemoteControl that returns the SmartLight object, allowing access to its status.
//3.RemoteControl class also should have function to change brightness
package homework9_SmartLight;

public class Main {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        System.out.println("---------------------------------");
        SmartLight a = new SmartLight(true, 75, "green");
        remoteControl.getLightStatus(a);
        System.out.println("---------------------------------");
        remoteControl.resetLight(a);
        remoteControl.getLightStatus(a);
        System.out.println("---------------------------------");
        remoteControl.changeBrightness(88, a);
//        remoteControl.toggle(a);
        remoteControl.getLightStatus(a);
    }
}