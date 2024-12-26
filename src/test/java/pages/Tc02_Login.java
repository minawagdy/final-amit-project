package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepDefs.Hooks;

public class Tc02_Login {

    public WebDriver driver= Hooks.driver;


    public WebElement loginLink() {

        return driver.findElement(By.id("login2"));
    }

    public WebElement username() {
        return driver.findElement(By.id("loginusername"));
    }

    public WebElement password()
    {
        return driver.findElement(By.id("loginpassword"));
    }

    public WebElement loginButton() {
        return driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));
    }
}
