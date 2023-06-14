//Проверка возможности открыть топовую статью на странице https://www.livejournal.com
package HW6_Tests;

import HW6.MainPage;
import HW6.TopPage;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class HW6_Test_1 extends AbstractTest {
    @Test
    void searching() throws InterruptedException {
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage
                .clickButtonTop();
        String expectedTitle = mainPage.getTopTitle();

        TopPage topPage = new TopPage(getWebDriver());
        topPage
                .clickTopResult();
        String actualTitle = topPage.getArticleTitle();

        Thread.sleep(5000);
        Assertions.assertEquals(expectedTitle, actualTitle, "Заголовки статей не совпадают");
    }
}