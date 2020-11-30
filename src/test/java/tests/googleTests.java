package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class googleTests {

    private static WebDriver driver;

    @BeforeAll
    public static void init () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\Users\\1\\AppData\\Local\\Temp\\scoped_dir11020_965565560\\Default");
        options.addArguments("--profile-directory=Default");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }
    @Test
    public void test1() {
        driver.get ("http://www.google.com/");
        driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys("selenium", Keys.ENTER);
        assertEquals(10, driver.findElements(By.cssSelector("#search .g")).size());
    }
    @AfterAll
    public static void teardown () {driver.quit();}
}
