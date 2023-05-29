//Проверка работы авторизации пользователя на https://www.livejournal.com (пара логин и пароль зарегистрированы).
package LiveJournale;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class hw3_test_2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");
        //options.setPageLoadStrategy(PageLoadStrategy.NONE);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com/");


        WebElement login = driver.findElement(By.xpath
                ("//*[@id=\"js\"]/body/div[3]/header/div[1]/nav[2]/ul/li[2]/a"));
        login.click();

        WebElement name = driver.findElement(By.xpath("//*[@id=\"user\"]"));
        name.click();
        name.sendKeys("Tester20230517");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"lj_loginwidget_password\"]"));
        password.click();
        password.sendKeys("123PA$$w0rd!@#");

        WebElement buttonEnter = driver.findElement(By.xpath("//button[@name='action:login']"));
        buttonEnter.click();

        Thread.sleep(10000);
        driver.quit();
    }
}

