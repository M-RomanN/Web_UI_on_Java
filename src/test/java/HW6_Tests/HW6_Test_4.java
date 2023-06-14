//Проверка возможности открыть страницу создания статьи (ресурс: https://www.livejournal.com)

package HW6_Tests;

import HW6.MainPage;
import HW6.PersonalAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class HW6_Test_4 extends AbstractTest {
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

        PersonalAccount personalAccount = new PersonalAccount(getWebDriver());
        personalAccount
                .clickFirstBlog();
        Thread.sleep(5000);
        Assertions.assertDoesNotThrow(() -> getWebDriver().findElement(By.cssSelector("#content > div > div >" +
                " div.title-0-2-93.alignment-0-2-91.root-0-2-121 > textarea")));
    }
}
