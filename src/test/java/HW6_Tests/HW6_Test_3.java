//Проверка загрузки страницы пользователя (https://tester20230517.livejournal.com/)
package HW6_Tests;

import HW6.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class HW6_Test_3 extends AbstractTest {
    @Test
    void searching() throws InterruptedException {
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage
                .clickLogin()
                .sendName("Tester20230517")
                .sendPassword("123PA$$w0rd!@#")
                .clickButtonEnter()
                .clickUserMenu();
        Thread.sleep(5000);


        Assertions.assertDoesNotThrow(() -> getWebDriver().findElement(By.xpath("//*[@id=\"home\"]/div[3]" +
                "/div[3]/div/div[1]/div[2]/div/header/div[1]/div[2]/div/div[1]/span[2]")));
    }
}
