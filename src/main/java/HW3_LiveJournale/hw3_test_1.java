//Проверка возможности открыть топовую статью на странице https://www.livejournal.com
//Кейс заменён (ранее проверялся поиск пользователем, не прошедшим авторизацию, определённой статьи на
// https://www.livejournal.com, но передать критерий поиска не удаётся (код кейса сзакомментирован)).

package HW3_LiveJournale;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class hw3_test_1 {
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

        WebElement top = driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[1]/header/div[1]/nav[1]/div/ul/li[3]/a"));
        top.click();

        WebElement topResult = driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[1]/div[5]/div[1]/section/div[1]/div/div[2]/article[1]/header/h3/a"));
        topResult.click();

        /*
        Первый кейс (поиск статьи) заменён, т.к. я не смог победить проблему с вводом текста в строку запроса.
        //Search
        WebElement buttonSearchBox = driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[1]/header/div[1]/nav[2]/ul/li[1]/div/form/button"));
        buttonSearchBox.click();
        buttonSearchBox.sendKeys("Google сможет превратить ваш смартфон в видеорегистратор");
        Thread.sleep(1000);
        buttonSearchBox.submit();
        Thread.sleep(1000);
        WebElement resultSearch = driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[1]/div[5]/div[1]/div/section/div/div[2]/ul/li/div/a"));
        resultSearch.click();
        */
        Thread.sleep(5000);
        driver.quit();
    }
}


