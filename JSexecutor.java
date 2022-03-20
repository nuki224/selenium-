import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class JSexecutor {
    @Test
    public void deleteItem () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        driver.manage().window().maximize();
        WebElement menu = driver.findElement(By.xpath(("//*[contains(text(),'Practice magic')]")));
        Actions action = new Actions(driver);
        action.moveToElement(menu).perform();
        WebElement submenu = driver.findElement(By.cssSelector("#container>ul>li:nth-child(3)>span>i"));
        action.moveToElement(submenu).click().perform();
    }
    @Test
    public void scroll () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        driver.get("http://webdriveruniversity.com/Scrolling/index.html ");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("zone2-entries"));
        Actions a = new Actions(driver);
        a.moveToElement(element);
        a.perform();
        System.out.println("Text is: " + element.getText());
    }
}
