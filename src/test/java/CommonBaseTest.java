import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class CommonBaseTest {
    WebDriver driver;

    //Выбор браузера для прогона тестов_
    @Before
    public void setUp() {
        //Закомментировать нужное - Chrome или Firefox
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        //FirefoxOptions options = new FirefoxOptions();
        //driver = new FirefoxDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    //Закрыть браузер
    @After
    public void tearDown() {
        if(driver != null){
            driver.quit();
        }
    }

}
