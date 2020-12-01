package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.DetailsPage;
import pages.SearchPage;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class googleTests {

    private static WebDriver driver;
    private static SearchPage searchPage;
    private static DetailsPage detailsPage;

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
    }
    @BeforeEach
    public void setup(){driver.get ("http://www.google.com/");}

    @Test
    @DisplayName("Проверка операций с целыми числами")
    public void test1() {
        searchPage.search("Калькулятор");
        driver.findElement(By.xpath("//div[@role='button' and @aria-label='открывающая скобка']")).click();
        driver.findElement(By.xpath("//div[@role='button' and @jsname='N10B9']")).click();
        driver.findElement(By.xpath("//div[@role='button' and @aria-label='сложение']")).click();
        driver.findElement(By.xpath("//div[@role='button' and @jsname='lVjWed']")).click();
        driver.findElement(By.xpath("//div[@role='button' and @aria-label='закрывающая скобка']")).click();
        driver.findElement(By.xpath("//div[@role='button' and @aria-label='умножение']")).click();
        driver.findElement(By.xpath("//div[@role='button' and @jsname='KN1kY']")).click();
        driver.findElement(By.xpath("//div[@role='button' and @aria-label='вычитание']")).click();
        driver.findElement(By.xpath("//div[@role='button' and @jsname='xAP7E']")).click();
        driver.findElement(By.xpath("//div[@role='button' and @jsname='bkEvMb']")).click();
        driver.findElement(By.xpath("//div[@role='button' and @aria-label='деление']")).click();
        driver.findElement(By.xpath("//div[@role='button' and @jsname='Ax5wH']")).click();
        driver.findElement(By.xpath("//div[@role='button' and @aria-label='равно']")).click();
        assertEquals("(1 + 2) × 3 - 40 ÷ 5 =", driver.findElement(By.xpath("//span[@jsname='ubtiRe' and @class='vUGUtc']")).getText());
        assertEquals("1", driver.findElement(By.xpath("//span[@jsname='VssY5c' and @class='qv3Wpe']")).getText());
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
