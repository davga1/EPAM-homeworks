//Create a SmartLight class with private attributes
// isOn (boolean), brightness (0-100), and color (String). Implement getters and setters for each field.
// Add a method toggle() that switches the light on or off.
//Create a RemoteControl class that can interact with a SmartLight object by passing the SmartLight instance as a parameter to its methods.
//1.Add a method resetLight() in RemoteControl that resets the SmartLight attributes to default values (off, brightness 50, color “white”).
//2.Implement a SmartLight getLightStatus() method in the RemoteControl that returns the SmartLight object, allowing access to its status.
//3.RemoteControl class also should have function to change brightness
package homework9_SmartLight;

public class Main {
    static void displayStatus(SmartLight smartLight) {
        System.out.println("Light on:" + smartLight.getIsOn() + "\nBrightness:" + smartLight.getBrightness() + "\nColor:" + smartLight.getColor());
    }

    public static void main(String[] args) {
        System.out.println("---------------------------------");
        SmartLight a = new SmartLight();
        a.setBrightness(75);
        a.setColor("blue");
        a.setIsOn(true);
        displayStatus(a);
        System.out.println("---------------------------------");
        a.toggle();
        displayStatus(a);
        System.out.println("---------------------------------");
        RemoteControl b = new RemoteControl(a);
        b.resetLight();
        displayStatus(a);
        System.out.println("---------------------------------");
        b.changeBrightness(88);
        SmartLight c = b.getLightStatus();
        displayStatus(c);
    }
}

class SmartLight {
    private boolean isOn = false;
    private int brightness = 50;
    private String color = "white";

    // setters and getters
    public boolean getIsOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // method toggle
    public void toggle() {
        isOn = !isOn;
    }
}

class RemoteControl {
    private SmartLight smartLight;

    public RemoteControl(SmartLight smartLight) {
        this.smartLight = smartLight;
    }

    //1.Add a method resetLight() in RemoteControl that resets the SmartLight attributes to default values (off, brightness 50, color “white”).
    public void resetLight() {
        smartLight.setIsOn(false);
        smartLight.setBrightness(50);
        smartLight.setColor("white");
    }

    //2.Implement a SmartLight getLightStatus() method in the RemoteControl that returns the SmartLight object, allowing access to its status.
    public SmartLight getLightStatus() {
        return this.smartLight;
    }

    //3.RemoteControl class also should have function to change brightness
    public void changeBrightness(int brightness) {
        if (brightness < 0) {
            smartLight.setBrightness(0);
        } else if (brightness > 100) {
            smartLight.setBrightness(100);
        } else smartLight.setBrightness(brightness);
    }
}