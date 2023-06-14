//Проверка работы выхода из профиля пользователя на https://www.livejournal.com.
package HW6_Tests;

import HW6.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class HW6_Test_5 extends AbstractTest {
    @Test
    void searching() throws InterruptedException {
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage
                .clickLogin()
                .sendName("Tester20230517")
                .sendPassword("123PA$$w0rd!@#")
                .clickButtonEnter();

        Thread.sleep(5000);

        MainPage mainPageAfterLogin = new MainPage(getWebDriver());
        mainPageAfterLogin
                .moveToElement(mainPageAfterLogin.userMenu)
                .clickLogout();
        Thread.sleep(5000);

        Assertions.assertDoesNotThrow(() -> getWebDriver().findElement(By.xpath("//*[@id=\"js\"]/body" +
                "/div[3]/header/div[1]/nav[2]/ul/li[2]/a")));
        Thread.sleep(1000);
    }
}
