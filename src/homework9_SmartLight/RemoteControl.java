package homework9_SmartLight;

public class RemoteControl {

    public RemoteControl() {}

    //1.Add a method resetLight() in RemoteControl that resets the SmartLight attributes to default values (off, brightness 50, color “white”).
    public void resetLight(SmartLight smartLight) {
        smartLight.setIsOn(false);
        smartLight.setColor("white");
        smartLight.setBrightness(50);
    }

    //2.Implement a SmartLight getLightStatus() method in the RemoteControl that returns the SmartLight object, allowing access to its status.
    public void getLightStatus(SmartLight smartLight) {
        System.out.println("Light on:" + smartLight.getIsOn() + "\nBrightness:" + smartLight.getBrightness() + "\nColor:" + smartLight.getColor());
    }

    //3.RemoteControl class also should have function to change brightness
    public void changeBrightness(int brightness, SmartLight smartLight) {
        if (brightness < 0) {
            smartLight.setBrightness(0);
        } else if (brightness > 100) {
            smartLight.setBrightness(100);
        } else smartLight.setBrightness(brightness);
    }

    public void toggle(SmartLight smartLight) {
        smartLight.toggle();
    }
}
