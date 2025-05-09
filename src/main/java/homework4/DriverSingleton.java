package homework4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public enum DriverSingleton {
    INSTANCE;

    private final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            String browser = System.getProperty("browser");
            if (browser == null) {
                throw new IllegalStateException("System property 'browser' is not set");
            }

            switch (browser.toLowerCase()) {
                case "chrome":
                    driverThreadLocal.set(new ChromeDriver());
                    break;
                case "edge":
                    driverThreadLocal.set(new EdgeDriver());
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
        return driverThreadLocal.get();
    }

    public void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}
