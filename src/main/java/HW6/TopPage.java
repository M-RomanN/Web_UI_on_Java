package HW6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopPage extends AbstractPageHW6 {
    @FindBy(xpath = "//*[@id=\"js\"]/body/div[1]/div[5]/div[1]/section/div[1]/div/div[2]/article[1]/header/h3/a")
    private WebElement topResult;

    public TopPage(WebDriver driver) {
        super(driver);
    }
    public TopPage clickTopResult(){
        topResult.click();
        return this;
    }
}
