package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepDefs.Hooks;

import java.util.List;

public class Tc03_Product {

    public WebDriver driver= Hooks.driver;


    public WebElement selectLaptopCategory(String category){
        return driver.findElement(By.xpath("//a[text()='Laptops']"));
    }
    public WebElement selectFirstProduct(String productName){
        return driver.findElement(By.xpath("//a[text()='Sony vaio i5']"));
    }
    public WebElement addToCart(){
        return driver.findElement(By.xpath("//a[contains(@onclick, 'addToCart(8)')]"));
    }
    public WebElement selectSecondProduct(String productName){
        return driver.findElement(By.xpath("//a[text()='MacBook air']"));
    }
    public WebElement addSecondToCart(){
        return driver.findElement(By.xpath("//a[contains(@onclick, 'addToCart(11)')]"));
    }
    public WebElement cartButton(){
        return driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a"));
    }
    public List<WebElement> validateCart(){
        return driver.findElements(By.xpath("//*[@id='tbodyid']/tr"));

    }
    public WebElement validateFirstItemName(){
        return driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[2]"));

    }
    public WebElement validateSecondItemName(){
        return driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[2]/td[2]"));

    }

    public WebElement validateFirstItemPrice(){
        return driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[3]"));

    }
    public WebElement validateSecondItemPrice(){
        return driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[2]/td[3]"));

    }
    public WebElement validateTotal(){
        return driver.findElement(By.xpath("//*[@id=\"totalp\"]"));

    }
    public boolean cartContainsProduct(String productName) {
        List<WebElement> cartItems = validateCart();
        for (WebElement item : cartItems) {
            String itemName = item.findElement(By.xpath("./td[2]")).getText(); // Assuming the product name is in the second column
            if (itemName.equalsIgnoreCase(productName)) {
                return true; // Product found in the cart
            }
        }
        return false; // Product not found in the cart
    }
    public WebElement placeOrderButton(){
        return driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button"));
    }
    public WebElement Name() {
        return driver.findElement(By.id("name"));
    }
    public WebElement Country() {
        return driver.findElement(By.id("country"));
    }
    public WebElement City() {
        return driver.findElement(By.id("city"));
    }
    public WebElement CreditCard() {
        return driver.findElement(By.id("card"));
    }
    public WebElement Month() {
        return driver.findElement(By.id("month"));
    }
    public WebElement Year() {
        return driver.findElement(By.id("year"));
    }
    public WebElement PurchaseButton() {
        return driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]"));
    }
    public WebElement orderSuccessMessage() {
        return  driver.findElement(By.xpath("//div[contains(@class, 'success')]/h2"));
    }





}
