package homework4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestClass {
    static {
        System.setProperty("browser", "chrome"); // or "edge"
    }
    WebDriver driver = SingletonClass.getInstance();
    JobPage j = new JobPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeAll
    public void goTo() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://staff.am/jobs");
        Thread.sleep(1500);
        j.clickOnAllViewMoreButtons();
    }

//    @AfterAll
//    public void quitDriver() {
//        driver.quit();
//    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    public void a(int number) throws InterruptedException {
        String[] names = j.filtersWebElementList.get(number).getText().split("\n");
        System.out.println(Arrays.toString(names));
        List<String> a = new ArrayList<>();
        if(names.length > 5){
            a.addAll(Arrays.asList(names).subList(1, names.length - 1));
        } else {
            a.addAll(Arrays.asList(names).subList(1, names.length));
        }
        Random random = new Random();
        int randomNum1 = random.nextInt(a.size());
        System.out.println(a);
        System.out.println(randomNum1);
        String name1 = a.get(randomNum1);
        String name2 = "";
        int randomNum2;
        do {
            randomNum2 = random.nextInt(a.size());
        } while (randomNum2 == randomNum1);
        name2 = a.get(randomNum2);
        Assertions.assertTrue(j.validateCount(name1));
        j.clearAllFilters();
        Assertions.assertTrue(j.validateCount(name1, name2));
        Assertions.assertTrue(j.validateCount(name2));
        //Still not finished because of the bug that I don't know how to solve
    }

}
