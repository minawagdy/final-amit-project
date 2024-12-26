package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.Tc03_Product;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class TC03_productSteps {
    Tc03_Product productPage = new Tc03_Product();

    @Given("I click on {string} under categories on the homepage")
    public void i_click_on_under_categories_on_the_homepage(String category) {
        productPage.driver.navigate().to("https://www.demoblaze.com/index.html");
        WebDriverWait wait = new WebDriverWait(productPage.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(productPage.selectLaptopCategory(category)));
        productPage.selectLaptopCategory(category).click();
    }

    @When("I select Product 1 {string}")
    public void i_select_product_1(String productName) {
        WebDriverWait wait = new WebDriverWait(productPage.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(productPage.selectFirstProduct(productName)));
        productPage.selectFirstProduct(productName).click();
    }

    @And("I click on the Add to Cart button")
    public void i_click_on_the_add_cart_button() {
        WebDriverWait wait = new WebDriverWait(productPage.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(productPage.addToCart()));
        productPage.addToCart().click();
    }

    @Then("I should see a confirmation message {string}")
    public void i_should_see_a_confirmation_message(String message) {
        SoftAssert softAssert = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(productPage.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String actualResult = productPage.driver.switchTo().alert().getText();
        softAssert.assertEquals(actualResult, message, "Product added.");
        productPage.driver.switchTo().alert().accept();
        softAssert.assertAll();
    }
    @When("I select Product 2 {string}")
    public void i_select_product_2(String productName) {
        WebDriverWait wait = new WebDriverWait(productPage.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(productPage.selectSecondProduct(productName)));
        productPage.selectSecondProduct(productName).click();
    }

    @When("I click on the Add second to Cart button")
    public void i_click_on_the_add_second_to_cart_button() {
        WebDriverWait wait = new WebDriverWait(productPage.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(productPage.addSecondToCart()));
        productPage.addSecondToCart().click();
    }
    @Given("I click on the cart button in the header")
    public void i_click_on_the_cart_button_in_the_header() {
        productPage.cartButton().click();
    }
    @Then("I should see both products {string} and {string} in the cart with their respective titles and prices")
    public void i_should_see_both_products_and_in_the_cart_with_their_respective_titles_and_prices(String product1, String product2) {
        WebDriverWait wait = new WebDriverWait(productPage.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(productPage.validateCart()));

        // Collect all product names in the cart
        List<String> cartProductNames = productPage.validateCart().stream()
            .map(item -> item.findElement(By.xpath("./td[2]")).getText()) // Assuming the product name is in the second column
            .toList();

        System.out.println("Products in cart: " + cartProductNames);

        // Validate that both products are present in the cart
        Assert.assertTrue(cartProductNames.contains(product1), "Cart does not contain product: " + product1);
        Assert.assertTrue(cartProductNames.contains(product2), "Cart does not contain product: " + product2);
    }

    @Given("I am on the cart page with products {string} and {string}")
    public void i_am_on_the_cart_page_with_products_and(String product1, String product2) {
        System.out.println("Navigating to the cart page...");
        // Add logic to navigate to the cart page, ensuring the cart contains the specified products
        Assert.assertTrue(productPage.cartContainsProduct(product1), "Cart does not contain product: " + product1);
        Assert.assertTrue(productPage.cartContainsProduct(product2), "Cart does not contain product: " + product2);
    }

    @When("I validate the total amount displayed in the cart")
    public void i_validate_the_total_amount_displayed_in_the_cart() {
        // Write code here that turns the phrase above into concrete actions
        productPage.validateTotal().getText();
        String displayedTotal = productPage.validateTotal().getText();
        Assert.assertFalse(displayedTotal.isEmpty(), "The total amount displayed is empty.");
        Assert.assertTrue(Integer.parseInt(displayedTotal) > 0, "The total amount displayed is not valid.");
    }
    @Then("The total amount should be calculated correctly based on the prices of both products")
    public void the_total_amount_should_be_calculated_correctly_based_on_the_prices_of_both_products() {
        int price1 = Integer.parseInt(productPage.validateFirstItemPrice().getText());
        int price2 = Integer.parseInt(productPage.validateSecondItemPrice().getText());
        int total = price1 + price2;

        System.out.println("Price of first product: " + price1);
        System.out.println("Price of second product: " + price2);
        System.out.println("Calculated total: " + total);

        int displayedTotal = Integer.parseInt(productPage.validateTotal().getText());
        System.out.println("Displayed total: " + displayedTotal);

        Assert.assertEquals(displayedTotal, total, "The displayed total does not match the calculated total.");
    }
    @Given("I click on the Place Order button")
    public void i_click_on_the_place_order_button() {
        productPage.placeOrderButton().click();
    }
    @When("I fill in my purchase details:")
    public void i_fill_in_my_purchase_details(io.cucumber.datatable.DataTable dataTable) {
        // Convert the DataTable to a List of Maps (key-value pairs)
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        // Loop through the rows of the DataTable and fill in the form fields
        for (Map<String, String> row : data) {
            // Fill in the Name field
            productPage.Name().sendKeys(row.get("Name"));

            // Fill in the Country field
            productPage.Country().sendKeys(row.get("Country"));

            // Fill in the City field
            productPage.City().sendKeys(row.get("City"));

            // Fill in the Credit Card field
            productPage.CreditCard().sendKeys(row.get("Card"));

            // Fill in the Month field
            productPage.Month().sendKeys(row.get("Month"));

            // Fill in the Year field
            productPage.Year().sendKeys(row.get("Year"));
        }
    }
    @And("I click on the purchase button")
    public void i_click_on_the_purchase_button(){
        productPage.PurchaseButton().click();

    }
    @Then("I should see a success message {string}")
    public void i_should_see_a_success_message(String message) {
        WebDriverWait wait = new WebDriverWait(productPage.driver, Duration.ofSeconds(10));

        // Wait until the success message is visible
        WebElement successMessageElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='" + message + "']"))
        );

        // Assert the text matches the expected message
        String actualMessage = successMessageElement.getText();
        Assert.assertEquals(actualMessage, message, "Success message does not match!");
    }



}
