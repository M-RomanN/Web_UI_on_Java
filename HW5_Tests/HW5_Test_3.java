//Проверка открытия страницы пользователя (https://www.livejournal.com/inbox/?view=usermsg_recvd).

package HW5_Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HW5_Test_3 extends AbstractTest {
    @Test
    void test() throws InterruptedException {
        getDriver().get("https://www.livejournal.com");

        WebElement login = getDriver().findElement(By.xpath
                ("//*[@id=\"js\"]/body/div[3]/header/div[1]/nav[2]/ul/li[2]/a"));
        login.click();

        WebElement name = getDriver().findElement(By.xpath("//*[@id=\"user\"]"));
        name.click();
        name.sendKeys("Tester20230517");

        WebElement password = getDriver().findElement(By.xpath("//*[@id=\"lj_loginwidget_password\"]"));
        password.click();
        password.sendKeys("123PA$$w0rd!@#");

        WebElement buttonEnter = getDriver().findElement(By.xpath("//button[@name='action:login']"));
        buttonEnter.click();

        WebElement userMenu = getDriver().findElement(By.cssSelector("body > div.s-layout.body-content.s-logged-in > " +
                "header > div.s-header-in.clearfix > nav.s-nav-actions > ul >" +
                " li.s-header-item.s-header-item--right.s-header-item--user.s-header-item--has-sub." +
                "s-header-item--personal.s-drop-master > a > span"));
        userMenu.click();

        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.xpath("//*[@id=\"home\"]/div[3]" +
                "/div[3]/div/div[1]/div[2]/div/header/div[1]/div[2]/div/div[1]/span[2]")));
        Thread.sleep(5000);
    }
}