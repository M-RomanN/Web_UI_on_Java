package HW6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalAccount extends AbstractPageHW6 {
    @FindBy(xpath = "//*[@id=\"home\"]/div[3]/div[3]/div/div[1]/div[2]/div/div/div/section/div[1]/div/a")
    private WebElement firstBlog;

    public PersonalAccount(WebDriver driver) {
        super(driver);
    }

    public PersonalAccount clickFirstBlog() {
        firstBlog.click();
        return this;
    }
}

