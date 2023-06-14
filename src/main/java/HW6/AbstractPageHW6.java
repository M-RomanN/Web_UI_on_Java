package HW6;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageHW6 {

    public WebDriver driver;

    public AbstractPageHW6(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebDriver getDriver(){
        return this.driver;
    }

    public String getArticleTitle() {
        return null;
    }

    public String getTopTitle() {
        return null;
    }
}