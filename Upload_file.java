import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Upload_file {
    @Test
    public void uploadfile () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(" http://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        try {
            driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\User\\Desktop\\selenium-homework-1\\src\\main\\resources\\zuma.jpg");
            driver.findElement(By.id("file-submit")).click();
        } catch (StaleElementReferenceException e){
            System.out.println("Stale Element Refrence Exception invoked");
        }
    }
}
