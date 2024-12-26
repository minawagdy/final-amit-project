Feature:F01_Login | user uses your credential to login

    Scenario:Verify that the user can log in successfully.
             #Given Open the browser and goto "https://www.demoblaze.com"
        When User click on the log in button in the header
        And user fill in the username "minawa8" and password "mina@12" in the login form
        And  user click on the log in button

