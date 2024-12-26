package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.testng.annotations.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.TC01_Sign_Up;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
//import static org.testng.Assert.*;
//import java.time.Duration;


public class TC01_signUpSteps {

    WebDriver driver = Hooks.driver;
    TC01_Sign_Up signUpPage = new TC01_Sign_Up(driver); // Pass WebDriver to the constructor


    @When("I click on the Sign Up button in the header")
    public void i_click_on_the_sign_up_button_in_the_header() {
//        if (button.equals("Sign Up")) {
            signUpPage.signupLink().click();
//        }
    }

    @When("I fill in the username {string} and password {string} in the sign-up form")
    public void i_fill_in_the_username_and_password_in_the_sign_up_form(String username, String password) {
        signUpPage.username().sendKeys(username);
        signUpPage.password().sendKeys(password);
    }
    @When("I click on the {string} button")
    public void i_click_on_the_button(String string) {
        signUpPage.signupButton().click();

    }

    @Then("I should see a success message: {string}")
    public void i_should_see_a_success_message(String message) throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String ExpectedResult=message;
        String ActualResult=driver.switchTo().alert().getText();
        softAssert.assertEquals(ExpectedResult,ActualResult);
        softAssert.assertAll();
        driver.switchTo().alert().accept();
    }
//    @And("I fill in the username {string} and password {string} in the sign-up form")
//    public void iFillInTheUsernameAndPasswordInTheSignUpForm(String username, String password) {
//        signUpPage.username().sendKeys(username);
//        signUpPage.password().sendKeys(password);
//    }
//
//    @And("I click on the {string} button")
//    public void iClickOnTheButton(String button) {
//        if (button.equals("Sign Up")) {
//            signUpPage.signupButton().click();
//        }
//    }
//
//    @Then("I should see a success message: {string}")
//    public void iShouldSeeASuccessMessage(String message) {
//        WebDriverWait wait = new WebDriverWait(driver,10);
////        WebDriverWait wait = new WebDriverWait(driver,10);
//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        String alertText = alert.getText();
//        assertEquals(alertText, message);
//        alert.accept();
//    }
}
