package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC01_Sign_Up {
    private WebDriver driver;

    public TC01_Sign_Up(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement signupLink() {
        return driver.findElement(By.id("signin2"));
    }

    public WebElement username() {
        return driver.findElement(By.id("sign-username"));
    }

    public WebElement password() {
        return driver.findElement(By.id("sign-password"));
    }

    public WebElement signupButton() {
        return driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]"));
    }
}
