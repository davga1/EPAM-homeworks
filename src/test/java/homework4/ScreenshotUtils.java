package homework4;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static String sanitizeFileName(String input) {
        return input.replaceAll("[\\\\/:*?\"<>|()]", "_"); // replaces invalid chars with "_"
    }

    public static void savePageScreenshot(WebDriver driver, Path path) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshotFile.toPath(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Can't copy the screenshot file:" + e.getMessage());
        }
    }

    public static void addScreenshot(WebDriver driver, String e, String name, String screenshotName) throws IOException {
        String fileName = "Screenshot_on_failure_" + e.getClass().getSimpleName() + "_" + sanitizeFileName(name) + ".png";
        Path screenshotsDir = Path.of("screenshots");
        Files.createDirectories(screenshotsDir);
        Path path = screenshotsDir.resolve(fileName);
        ScreenshotUtils.savePageScreenshot(driver, path);
        Allure.addAttachment(screenshotName, "image/png", Files.newInputStream(path), ".png");
    }
}
