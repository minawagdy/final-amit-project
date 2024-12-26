package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class Hooks {

    public static WebDriver driver;


    @Before
    public void openBrowser() {
        String browserName = "edge";
        if (browserName.contains("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.contains("edge")) {
            driver = new EdgeDriver();
        } else if (browserName.contains("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();  // Default to Chrome
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/index.html");
    }

    @After
    public void quit() throws InterruptedException {
        if (driver != null) {
            driver.quit();
        }
    }

}
