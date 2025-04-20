package homework4;

import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.opentest4j.AssertionFailedError;

import java.io.IOException;
import java.util.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestClass {
    static {
        System.setProperty("browser", "chrome");
    }

    WebDriver driver = DriverSingleton.INSTANCE.getDriver();
    JobPage j = new JobPage(driver);

    @BeforeAll
    public void goTo() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://staff.am/jobs");
        j.clickOnAllViewMoreButtons();
    }

    @AfterAll
    public void quitDriver(){
        DriverSingleton.INSTANCE.quitDriver();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    public void a(int number) throws Exception {
        String[] names = j.filtersWebElementList.get(number).getText().split("\n");
        List<String> a = new ArrayList<>();
        if (names.length > 5) {
            a.addAll(Arrays.asList(names).subList(1, names.length - 1));
        } else {
            a.addAll(Arrays.asList(names).subList(1, names.length));
        }
        Random random = new Random();
        int randomNum1 = random.nextInt(a.size());
        String name1 = a.get(randomNum1);
        String name2 = "";
        int randomNum2;
        do {
            randomNum2 = random.nextInt(a.size());
        } while (randomNum2 == randomNum1);
        name2 = a.get(randomNum2);
        try {
            ScreenshotUtils.addScreenshot(driver, "Some screenshot", "Scrn", "Screenshot for test without failure");
            Assertions.assertTrue(j.validateCount(name1));
            j.clearAllFilters();
            Assertions.assertTrue(j.validateCount(name1, name2));
            Assertions.assertTrue(j.validateCount(name2));
        } catch (Exception | AssertionFailedError e) {
            ScreenshotUtils.addScreenshot(driver, e.getClass().getSimpleName(), name1, "Screenshot on failure");
            throw e;
        }
    }

}
