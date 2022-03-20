import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
    public WebDriver driver;
    @BeforeTest
    @Parameters("browser")
    public void setup (String browser) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                System.out.println("Browser is not correct");
            }
        }
    @Test
    public void deleteItem () {
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
        JavascriptExecutor jse =(JavascriptExecutor)driver;
        driver.get("http://webdriveruniversity.com/Scrolling/index.html ");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("zone2-entries"));
        Actions a = new Actions(driver);
        a.moveToElement(element);
        a.perform();
        System.out.println("Text is: " + element.getText());
    }
    @Test
    public void uploadfile () {
        driver.get(" http://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        try {
            driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\User\\Desktop\\selenium-homework-1\\src\\main\\resources\\zuma.jpg");
            driver.findElement(By.id("file-submit")).click();
        } catch (StaleElementReferenceException e){
            System.out.println("Stale Element Refrence Exception invoked");
        }
    }
    @AfterTest
    void tearDown () {
        driver.quit();
    }
}

