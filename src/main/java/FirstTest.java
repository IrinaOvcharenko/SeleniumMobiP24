import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    By Phone = By.xpath("//input[@data-qa-node='phone-number']");
    By Sum = (By.xpath("//input[@data-qa-node='amount']"));
    By FromCardNumber = By.xpath("//input[@data-qa-node='numberdebitSource']");
    By ExpirationDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    By CVV = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    By FirstName = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
    By LastName = By.xpath("//input[@data-qa-node='lastNamedebitSource']");


    @Test
    public void CheckMobiPayMinSum() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://next.privat24.ua/mobile");

        driver.findElement(Phone).sendKeys("933590788");
        driver.findElement(Sum).sendKeys("1");
        driver.findElement(FromCardNumber).sendKeys("5100000000000008");
        driver.findElement(ExpirationDate).sendKeys("1224");
        driver.findElement(CVV).sendKeys("111");
        driver.findElement(FirstName).sendKeys("IVAN");
        driver.findElement(LastName).sendKeys("IVANOV");


        Assert.assertEquals("933590788", driver.findElement(Phone).getText());
        Assert.assertEquals("1", driver.findElement(Sum).getText());
        Assert.assertEquals("5100000000000008", driver.findElement(FromCardNumber).getText());
        Assert.assertEquals("1224", driver.findElement(ExpirationDate).getText());
        Assert.assertEquals("111", driver.findElement(CVV).getText());
        Assert.assertEquals("IVAN", driver.findElement(FirstName).getText());
        Assert.assertEquals("IVANOV", driver.findElement(LastName).getText());

        
        driver.findElement(By.xpath(".//button[contains(text(), 'В кошик')]")).click();
    }
}

