//Проверка работы перехода на англоязычную версию https://www.livejournal.com
package HW6_Tests;

import HW6.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class HW6_Test_6 extends AbstractTest {

    @Test
    void searching() throws InterruptedException {
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage
                .moveToElement(mainPage.languageMenuActivate)
                .clickEnglishLanguage();

        Assertions.assertDoesNotThrow(() -> getWebDriver().findElement(By.xpath(".//span[contains(text()," +
                " 'English')]")));

        Thread.sleep(5000);

    }
}
