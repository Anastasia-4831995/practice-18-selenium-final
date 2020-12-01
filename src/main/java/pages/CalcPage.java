package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CalcPage {
       @FindBy(xpath="//div[@role='button' and @aria-label='открывающая скобка']")
       public WebElement otkrskobka;

       @FindBy(xpath="//div[@role='button' and @jsname='N10B9']")
       public WebElement odin;

       @FindBy(xpath="//div[@role='button' and @aria-label='сложение']")
       public WebElement pribavim;

       @FindBy(xpath="//div[@role='button' and @jsname='lVjWed']")
       public WebElement dva;

       @FindBy(xpath="//div[@role='button' and @aria-label='закрывающая скобка']")
       public WebElement zakrskobka;

       @FindBy(xpath="//div[@role='button' and @aria-label='умножение']")
       public WebElement umnozhim;

       @FindBy(xpath="//div[@role='button' and @jsname='KN1kY']")
       public WebElement tri;

       @FindBy(xpath="//div[@role='button' and @aria-label='вычитание']")
       public WebElement vychtem;

       @FindBy(xpath="//div[@role='button' and @jsname='xAP7E']")
       public WebElement chetyre;

       @FindBy(xpath="//div[@role='button' and @jsname='bkEvMb']")
       public WebElement noul;

       @FindBy(xpath="//div[@role='button' and @aria-label='деление']")
       public WebElement delim;

       @FindBy(xpath="//div[@role='button' and @jsname='Ax5wH']")
       public WebElement pyat;

       @FindBy(xpath="//div[@role='button' and @aria-label='равно']")
       public WebElement ravno;

       @FindBy(xpath="//span[@jsname='ubtiRe' and @class='vUGUtc']")
       public WebElement strokapamyati;

       @FindBy(xpath="//span[@jsname='VssY5c' and @class='qv3Wpe']")
       public WebElement strokarezultata;







    public CalcPage(WebDriver driver) {
        initElements(driver, this);
    }

   }
