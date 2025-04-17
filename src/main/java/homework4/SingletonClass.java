package homework4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SingletonClass {
    private static ThreadLocal<WebDriver> instance;

    private SingletonClass() {
        // Some setup process
    }

    public synchronized static WebDriver getInstance() {
        String browser = System.getProperty("browser");
        if (instance == null) {
            instance = new ThreadLocal<>();
            if (browser.equals("chrome"))
                instance.set(new ChromeDriver());
            if (browser.equals("edge"))
                instance.set(new EdgeDriver());
        }
        return instance.get();
    }

    public static void nullify() {
        instance = null;
    }
}
