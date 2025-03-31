import homework2.DriverManager;
import homework2.pages.StaffAMCompanyPage;
import homework2.pages.StaffAMMainPage;
import homework2.pages.StaffAMSearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class StaffAMTest {
    static Random random = new Random();

    static String getRandomString() {
        String a = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String b = "qwertyuiopasdfghjklzxcvbnm";
        String c = "0123456789";
        String d = a + b + c;
        String str = "";
        for (int i = 0; i < 10; i++) {
            str += d.charAt(random.nextInt(d.length()));
        }
        return str;
    }

    static WebElement getRandomElement(List<WebElement> a) {
        int num = random.nextInt(a.size());
        return a.get(num);
    }

    private WebDriver driver;


    //Մտնում եք https://staff.am

    @BeforeEach
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get("https://staff.am");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void quitDriver() {
        DriverManager.quitDriver();
    }

    @Test
    void test() throws InterruptedException {
        StaffAMMainPage mainPage = new StaffAMMainPage(driver);
        StaffAMSearchPage searchPage = new StaffAMSearchPage(driver);
        String industryName = "Information technologies";

        mainPage.clickOnCompaniesRadioButton();
        Thread.sleep(1500);
        //Ընտրում եք "Companies" radiobutton-ը հենց ինփութ ֆիլդեռի վեռևը
        mainPage.clickOnAllIndustriesDropdownButton();
        Thread.sleep(1500);
        //"All Industries" դրոփդաունից ընտրում եք Information technologies տարբերակը
        mainPage.clickOnVariantFromDropdown(industryName);
        Thread.sleep(1500);
        //Հետո սեղմում եք search-ի button-ի վրա։
        mainPage.clickOnSearchButton();
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
//        Արդյունքների էջում, վերևի հատվածում կա search-ի բաժին. այ ըտեղ փնտրում եք ինչ-որ random string, որը պիտի գեներացնեք։
        searchPage.searchWord(getRandomString());
        Thread.sleep(3000);
//        Համոզվում եք, որ արդյունքում ոչ մի կամպանիա չի գտնվել։
        Assertions.assertEquals(0, searchPage.getResultsCountInPage());
        //Ջնջում եք նախորդ փնտրածն ու էս անգամ փնտրում եք "ser" (օդնոյի հետ կապ չունի) բառը
        searchPage.clearTextFromSearchField();
        searchPage.searchWord("ser");
        Thread.sleep(3000);
        //Համոզվում եք, որ ֆիլտրված ցուցակի ցանկացածի անունը պարունակումա մեր գրած search-ի բառը։ Էս դեպքում ser-ը։
        Assertions.assertTrue(searchPage.checkCompanyNamesToHaveGivenWord("ser"));
        //Ընտրում եք դրանցից պատահական մեկը, ու մտնում եք իրա էջ
        searchPage.click(searchPage.getRandomCompanyLocator());
        Thread.sleep(2000);
        StaffAMCompanyPage companyPage = new StaffAMCompanyPage(driver);
        //Համոզվում եք, որ կամպանիայի անունը ու դրա տակի բոլոր թվային տվյալները տվյալները
        //(հետևորդներ, ակտիվ աշխատատեղեր և այլն) նույնն են, ինչ search-ի էջում էին տվյալ կամպանիայի համար։
        Assertions.assertEquals(List.of(searchPage.getPageViewCount(), searchPage.getFollowerCount(), searchPage.getActiveJobsCount(), searchPage.getJobHistoryNumber()), companyPage.getCompanyDetails());
        //Համոզվում եք, որ Industry դաշտի արժեքը նույննա, ինչ Դուք 3-րդ քայլում ընտրել էիք։
        Assertions.assertEquals(industryName, companyPage.getIndustryName());
    }
}
