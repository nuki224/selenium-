import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HeadlessTesting {
    @Test
    public void deleteItem () {
        HtmlUnitDriver unitDriver = new HtmlUnitDriver();
        unitDriver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        unitDriver.manage().window().maximize();
        WebElement menu = unitDriver.findElement(By.xpath(("//*[contains(text(),'Practice magic')]")));
        Actions action = new Actions(unitDriver);
        action.moveToElement(menu).perform();
        WebElement submenu = unitDriver.findElement(By.cssSelector("#container>ul>li:nth-child(3)>span>i"));
        action.moveToElement(submenu).click().perform();
    }
    @Test
    public void scroll () {
        HtmlUnitDriver unitDriver = new HtmlUnitDriver();
        JavascriptExecutor jse =(JavascriptExecutor)unitDriver;
        unitDriver.get("http://webdriveruniversity.com/Scrolling/index.html ");
        unitDriver.manage().window().maximize();
        WebElement element = unitDriver.findElement(By.id("zone2-entries"));
        Actions a = new Actions(unitDriver);
        a.moveToElement(element);
        a.perform();
        System.out.println("Text is: " + element.getText());
    }
    @Test
    public void uploadfile () {
        HtmlUnitDriver unitDriver = new HtmlUnitDriver();
        unitDriver.get(" http://the-internet.herokuapp.com/upload");
        unitDriver.manage().window().maximize();
        try {
            unitDriver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\User\\Desktop\\selenium-homework-1\\src\\main\\resources\\zuma.jpg");
            unitDriver.findElement(By.id("file-submit")).click();
        } catch (StaleElementReferenceException e){
            System.out.println("Stale Element Refrence Exception invoked");
        }
    }
}