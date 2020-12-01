package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class SearchPage {
    @FindBy(css="input.gLFyf.gsfi")
    private WebElement searchInput1;

    @FindBy(css="#search .g")
    public List<WebElement> results;

    @FindBy(css="#cwos .qv3Wpe")
    private WebElement searchInput2;

    public SearchPage(WebDriver driver) {
        initElements(driver, this);
    }

    public void search(String text){
        searchInput1.sendKeys(text, Keys.ENTER);
    }

    public void search1(String text){
        searchInput2.sendKeys(text, Keys.ENTER);
    }
}
