package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Tc02_Login;
import pages.Tc03_Product;

import java.time.Duration;

public class Tc02_loginSteps {

    Tc02_Login loginPage = new Tc02_Login(); // Pass WebDriver to the constructor

    @When("User click on the log in button in the header")
    public void user_click_on_the_log_in_button_in_the_header() {
        loginPage.loginLink().click();

    }
    @When("user fill in the username {string} and password {string} in the login form")
    public void user_fill_in_the_username_and_password_in_the_login_form(String username, String password) {
        WebDriverWait wait = new WebDriverWait(loginPage.driver, Duration.ofSeconds(10));
        loginPage.username().sendKeys(username);
        loginPage.password().sendKeys(password);
    }
    @When("user click on the log in button")
    public void user_click_on_the_log_in_button() {
        loginPage.loginButton().click();

    }
//    @Then("The account should open successfully, and the user should be logged in")
//    public void the_account_should_open_successfully_and_the_user_should_be_logged_in() {
//
//    }

//    }


}
