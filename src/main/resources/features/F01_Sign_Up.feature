Feature: Sign Up
    Scenario: Verify that user can sign up successfully
        When I click on the Sign Up button in the header
        And I fill in the username "minawa5" and password "mina@12" in the sign-up form
        And I click on the "Sign Up" button
        Then I should see a success message: "Sign up successful."
