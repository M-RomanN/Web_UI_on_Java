package HW6;

import org.codehaus.plexus.i18n.Language;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPageHW6 {
    @FindBy(css = "body > div.s-layout.body-content.s-logged-out > header > div.s-header-in.clearfix > nav.s-nav > div > ul > li:nth-child(3) > a")
    private WebElement buttonTop;
    @FindBy(xpath = "//*[@id=\"js\"]/body/div[3]/header/div[1]/nav[2]/ul/li[2]/a")
    private WebElement login;
    @FindBy(xpath = "//*[@id=\"user\"]")
    private WebElement name;
    @FindBy(xpath = "//*[@id=\"lj_loginwidget_password\"]")
    private WebElement password;
    @FindBy(xpath = "//button[@name='action:login']")
    private WebElement buttonEnter;
    @FindBy(css = "body > div.s-layout.body-content.s-logged-in > header > div.s-header-in.clearfix > nav.s-nav-actions > ul > li.s-header-item.s-header-item--right.s-header-item--user.s-header-item--has-sub.s-header-item--personal.s-drop-master > a > span")
    public WebElement userMenu;
    @FindBy(css = "body > div.s-layout.body-content.s-logged-in > header > div.s-header-in.clearfix > nav.s-nav-actions > ul > li.s-header-item.s-header-item--right.s-header-item--user.s-header-item--has-sub.s-header-item--personal.s-drop-master > ul > li.s-header-sub-list__item.s-header-sub-list-item.s-header-sub-list-item--special.s-nav-item-logout > a")
    private WebElement logout;
    @FindBy(css = "body > div.s-layout.body-content.s-logged-out > header > div.s-header-in.clearfix > nav.s-nav-actions > ul > li.s-nav-item.s-drop-master.s-nav-item-lang.s-header-item.s-header-item--right.s-header-item--has-sub > a")
    public WebElement languageMenuActivate;
//    @FindBy(xpath = "//*[@id=\"js\"]/body/div[3]/header/div[1]/nav[2]/ul/li[5]/ul")
//    @FindBy(xpath = "//*[@id=\"js\"]/body/div[1]/header/div[1]/nav[2]/ul/li[5]/ul/li[1]/a")
    @FindBy(css = "body > div.s-layout.body-content.s-logged-out > header > div.s-header-in.clearfix > nav.s-nav-actions > ul > li.s-nav-item.s-drop-master.s-nav-item-lang.s-header-item.s-header-item--right.s-header-item--has-sub > ul > li:nth-child(1) > a")
    private WebElement englishLanguage;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickButtonTop() {
        buttonTop.click();
        return this;
    }

    public MainPage clickLogin() {
        login.click();
        return this;
    }

    public MainPage sendName(String text) {
        this.name.click();
        this.name.sendKeys(text);
        return this;
    }

    public MainPage sendPassword(String text) {
        this.password.click();
        this.password.sendKeys(text);
        return this;
    }

    public MainPage clickButtonEnter() {
        buttonEnter.click();
        return this;
    }

    public MainPage clickUserMenu() {
        userMenu.click();
        return this;
    }

    public MainPage clickLogout() {
        logout.click();
        return this;
    }

    public MainPage moveToElement(WebElement webElement) {
        new Actions(driver).moveToElement(webElement).perform();
        return this;
    }

    public MainPage languageMenuActivate(WebElement webElement) {
        new Actions(driver).moveToElement(webElement).perform();
        return this;
    }

    public MainPage clickEnglishLanguage() {
        englishLanguage.click();
        return this;
    }
}
