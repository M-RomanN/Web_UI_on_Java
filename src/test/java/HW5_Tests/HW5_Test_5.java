//Проверка работы выхода из профиля пользователя на https://www.livejournal.com.
package HW5_Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class HW5_Test_5 extends AbstractTest {
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

        WebElement menu = getDriver().findElement(By.cssSelector("body > div.s-layout.body-content.s-logged-in > " +
                "header > div.s-header-in.clearfix > nav.s-nav-actions > ul > li.s-header-item.s-header-item--right." +
                "s-header-item--user.s-header-item--has-sub.s-header-item--personal.s-drop-master > a > span"));
        new Actions(getDriver())
                .moveToElement(menu)
                .perform();

        WebElement logout = getDriver().findElement(By.cssSelector("body > div.s-layout.body-content.s-logged-in >" +
                " header > div.s-header-in.clearfix > nav.s-nav-actions > ul > li.s-header-item." +
                "s-header-item--right.s-header-item--user.s-header-item--has-sub.s-header-item--personal." +
                "s-drop-master > ul > li.s-header-sub-list__item.s-header-sub-list-item." +
                "s-header-sub-list-item--special.s-nav-item-logout > a"));
        logout.click();

        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.xpath("//*[@id=\"js\"]/body" +
                "/div[3]/header/div[1]/nav[2]/ul/li[2]/a")));
        Thread.sleep(5000);
    }
}