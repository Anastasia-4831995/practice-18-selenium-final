package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CalcPage;
import pages.DetailsPage;
import pages.SearchPage;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class googleTests {

    private static WebDriver driver;
    private static SearchPage searchPage;
    private static DetailsPage detailsPage;
    private static CalcPage calcPage;

    @BeforeAll
    public static void init () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\Users\\1\\AppData\\Local\\Temp\\scoped_dir11020_965565560\\Default");
        options.addArguments("--profile-directory=Default");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        searchPage = new SearchPage(driver);
        detailsPage = new DetailsPage(driver);
        calcPage = new CalcPage(driver);
    }
    @BeforeEach
    public void setup(){driver.get ("http://www.google.com/");}

    @Test
    @DisplayName("Проверка операций с целыми числами")
    public void test1() {
        searchPage.search("Калькулятор");
        calcPage.otkrskobka.click();
        calcPage.odin.click();
        calcPage.pribavim.click();
        calcPage.dva.click();
        calcPage.zakrskobka.click();
        calcPage.umnozhim.click();
        calcPage.tri.click();
        calcPage.vychtem.click();
        calcPage.chetyre.click();
        calcPage.noul.click();
        calcPage.delim.click();
        calcPage.pyat.click();
        calcPage.ravno.click();
        assertEquals("(1 + 2) × 3 - 40 ÷ 5 =", calcPage.strokapamyati.getText());
        assertEquals("1", calcPage.strokarezultata.getText());
    }

    @Test
    @DisplayName("Проверка деления на ноль")
    public void test2() {
        searchPage.search("Калькулятор");
        driver.findElement(By.xpath("//div[@role='button' and @jsname='abcgof']")).click();
        driver.findElement(By.xpath("//div[@role='button' and @aria-label='деление']")).click();
        driver.findElement(By.xpath("//div[@role='button' and @jsname='bkEvMb']")).click();
        driver.findElement(By.xpath("//div[@role='button' and @aria-label='равно']")).click();
        assertEquals("6 ÷ 0 =", driver.findElement(By.xpath("//span[@jsname='ubtiRe' and @class='vUGUtc']")).getText());
        assertEquals("Infinity", driver.findElement(By.xpath("//span[@jsname='VssY5c' and @class='qv3Wpe']")).getText());
    }

    @Test
    @DisplayName("Проверка ошибки при отсутствии значения")
    public void test3() {
        searchPage.search("Калькулятор");
        driver.findElement(By.xpath("//div[@role='button' and @aria-label='синус']")).click();
        driver.findElement(By.xpath("//div[@role='button' and @aria-label='равно']")).click();
        assertEquals("sin() =", driver.findElement(By.xpath("//span[@jsname='ubtiRe' and @class='vUGUtc']")).getText());
        assertEquals("Error", driver.findElement(By.xpath("//span[@jsname='VssY5c' and @class='qv3Wpe']")).getText());
    }

    @AfterAll
    public static void teardown () {
        driver.quit();
    }
}
