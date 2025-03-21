package homework9_SmartLight;

public class SmartLight {
    private boolean isOn;
    private int brightness;
    private String color;


    public SmartLight(boolean isOn, int brightness, String color) {
        setIsOn(isOn);
        setBrightness(brightness);
        setColor(color);
    }

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
        if (brightness < 0) {
            this.brightness = 0;
        } else if (brightness > 100) {
            this.brightness = 100;
        } else this.brightness = brightness;
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
