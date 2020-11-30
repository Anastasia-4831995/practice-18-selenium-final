package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.SearchPage;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class googleTests {

    private static WebDriver driver;
    private static SearchPage searchPage;

    @BeforeAll
    public static void init () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\Users\\1\\AppData\\Local\\Temp\\scoped_dir11020_965565560\\Default");
        options.addArguments("--profile-directory=Default");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        searchPage = new SearchPage(driver);
    }
    @Test
    public void test1() {
        driver.get ("http://www.google.com/");
        searchPage.search("selenium");
        assertEquals(10, searchPage.results.size());
    }


    @AfterAll
    public static void teardown () {driver.quit();}
}
