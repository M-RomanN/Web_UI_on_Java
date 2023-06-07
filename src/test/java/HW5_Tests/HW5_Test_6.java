//Проверка работы перехода на англоязычную версию https://www.livejournal.com
package HW5_Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HW5_Test_6 extends AbstractTest {
    @Test
    void test() throws InterruptedException {
        getDriver().get("https://www.livejournal.com");

        WebElement menu = getDriver().findElement(By.cssSelector("body > div.s-layout.body-content.s-logged-out > " +
                "header > div.s-header-in.clearfix > nav.s-nav-actions > ul > li.s-nav-item.s-drop-master." +
                "s-nav-item-lang.s-header-item.s-header-item--right.s-header-item--has-sub > a"));
        new Actions(getDriver())
                .moveToElement(menu)
                .perform();
        Thread.sleep(1000);
        WebElement buttonEnglish = getDriver().findElement(By.
                xpath("//*[@id=\"js\"]/body/div[3]/header/div[1]/nav[2]/ul/li[5]/ul/li[1]"));
        buttonEnglish.click();

        Assertions.assertDoesNotThrow(() -> getDriver().findElement(By.
                xpath(".//span[contains(text(), 'English')]")));

        Thread.sleep(10000);
    }
}
