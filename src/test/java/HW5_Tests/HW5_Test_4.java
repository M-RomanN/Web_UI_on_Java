//Проверка возможности открыть страницу создания статьи (ресурс: https://www.livejournal.com)
package HW5_Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HW5_Test_4 extends AbstractTest {
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
        //Thread.sleep(5000);
        WebElement userMenu = getDriver().findElement(By.cssSelector("body > div.s-layout.body-content.s-logged-in > " +
                "header > div.s-header-in.clearfix > nav.s-nav-actions > ul >" +
                " li.s-header-item.s-header-item--right.s-header-item--user.s-header-item--has-sub.s-header-item--" +
                "personal.s-drop-master > a > span"));
        userMenu.click();

        WebElement firstBlog = getDriver().findElement(By.xpath("//*[@id=\"home\"]/div[3]/div[3]/div/" +
                "div[1]/div[2]/div/div/div/section/div[1]/div/a"));
        firstBlog.click();

        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.cssSelector("#content > div > div >" +
                " div.title-0-2-93.alignment-0-2-91.root-0-2-121 > textarea")));
        Thread.sleep(10000);
    }
}
