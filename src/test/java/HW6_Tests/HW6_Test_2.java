//Проверка работы авторизации пользователя на https://www.livejournal.com (пара логин и пароль зарегистрированы).
package HW6_Tests;

import HW6.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class HW6_Test_2 extends AbstractTest {
    @Test
    void searching() throws InterruptedException {
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage
                .clickLogin()
                .sendName("Tester20230517")
                .sendPassword("123PA$$w0rd!@#")
                .clickButtonEnter();
        Thread.sleep(5000);
        Assertions.assertDoesNotThrow(() -> getWebDriver().findElement(By.cssSelector("body > div.s-layout.body-content." +
                "s-logged-in > header > div.s-header-in.clearfix > nav.s-nav-actions > ul > li.s-header-item." +
                "s-header-item--right.s-header-item--user.s-header-item--has-sub.s-header-item--personal." +
                "s-drop-master > ul > li.s-header-sub-list__item.s-header-sub-list-item." +
                "s-header-sub-list-item--special.s-nav-item-logout > a")));
    }
}
