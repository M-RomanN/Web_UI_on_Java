//Проверка возможности открыть топовую статью на странице https://www.livejournal.com
package HW5_Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.util.function.BooleanSupplier;

public class HW5_Test_1 extends AbstractTest {
    @Test
    void test() throws InterruptedException {
        getDriver().get("https://www.livejournal.com");

        WebElement top = getDriver().findElement(By.cssSelector("body > div.s-layout.body-content.s-logged-out >" +
                " header > div.s-header-in.clearfix > nav.s-nav > div > ul > li:nth-child(3) > a"));
        top.click();

        WebElement topResult = getDriver().findElement(By.xpath("//*[@id=\"js\"]/body/div[1]/div[5]" +
                "/div[1]/section/div[1]/div/div[2]/article[1]/header/h3/a"));
        topResult.click();
        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.xpath("/html/body/div[8]/div/div/" +
                "div[2]/div/div[1]/dl/dt[2]/div/a/span[1]")));

        Thread.sleep(5000);
    }
}
