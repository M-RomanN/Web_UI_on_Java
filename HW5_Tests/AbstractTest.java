package HW5_Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    private static WebDriver driver;
    private static Long time = 5l;
    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait( 2, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com/");
    }

   /*
    @BeforeEach
    void goTo(){
        Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://www.vstu.ru"), "Страница не доступна");
    }
*/
    @AfterAll
    static void close(){
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
