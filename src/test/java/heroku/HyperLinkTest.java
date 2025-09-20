package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HyperLinkTest {

    @Test
    void verifyNavigateHyperLinksSuccessfully() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/status_codes");

        String href = driver.findElement(By.linkText("200")).getAttribute("href");
        driver.findElement(By.linkText("200")).click();
        Assert.assertEquals(driver.getCurrentUrl(), href);
        driver.navigate().back();

        href = driver.findElement(By.linkText("301")).getAttribute("href");
        driver.findElement(By.linkText("301")).click();
        Assert.assertEquals(driver.getCurrentUrl(), href);
        driver.navigate().back();

        href = driver.findElement(By.linkText("404")).getAttribute("href");
        driver.findElement(By.linkText("404")).click();
        Assert.assertEquals(driver.getCurrentUrl(), href);
        driver.navigate().back();

        href = driver.findElement(By.linkText("500")).getAttribute("href");
        driver.findElement(By.linkText("500")).click();
        Assert.assertEquals(driver.getCurrentUrl(), href);
        driver.navigate().back();

        driver.quit();
    }
}
