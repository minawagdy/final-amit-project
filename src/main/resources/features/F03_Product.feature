@Smoke_Testing

Feature:F01_Product | user add product successfully

    Scenario:Verify that user can sign up successfully.

        # Step 1: Sign Up
        When I click on the Sign Up button in the header
        And I fill in the username "mina_wagdy" and password "mina@123" in the sign-up form
        And I click on the "Sign Up" button
        Then I should see a success message: "Sign up successful."
    @Smoke_Testing

    Scenario: Verify that the user can add products to the cart.
             #Step 1 : login
             #Given Open the browser and goto "https://www.demoblaze.com"
            When User click on the log in button in the header
            And user fill in the username "mina_wagdy" and password "mina@123" in the login form
            And  user click on the log in button

            #Step 2 : Add Products to Cart
            Given I click on "Laptops" under categories on the homepage
            And I select Product 1 "Sony vaio i5"
            And I click on the Add to Cart button
            Then I should see a confirmation message "Product added"

            #Step 3 : Add Second Product to Cart
            Given I click on "Laptops" under categories on the homepage
            And I select Product 2 "MacBook air"
            And I click on the Add second to Cart button
            Then I should see a confirmation message "Product added"

            #Step 4: Validate Cart
            Given I click on the cart button in the header
            Then I should see both products "Sony vaio i5" and "MacBook air" in the cart with their respective titles and prices

            #Step 5: Verify Total Amount Calculation
            Given I am on the cart page with products "Sony vaio i5" and "MacBook air"
            When I validate the total amount displayed in the cart
            Then The total amount should be calculated correctly based on the prices of both products

           # Step 6: Proceed to Checkout
           Given I click on the Place Order button
            When I fill in my purchase details:
                | Name | Country | City  | Card           | Month | Year |
                | Mina | Egypt   | Cairo | 12345678912345 | 12    | 2024 |
            And  I click on the purchase button
            Then I should see a success message "Thank you for your purchase!"
