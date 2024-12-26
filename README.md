
# Web Automation Final Project

This project demonstrates web automation using Selenium WebDriver, TestNG, and Cucumber (BDD). It includes automation of test cases with reporting features using Extent Report and Allure Report.

## Tools and Technologies Used
- **Programming Language**: Java 22
- **Automation Framework**: Selenium WebDriver
- **Test Framework**: TestNG
- **Behavior-Driven Framework**: Cucumber (BDD)
- **Reporting Tools**: Extent Report, Allure Report

## Prerequisites
Ensure the following tools are installed on your system:
1. **Java Development Kit (JDK 22)**: [Download here](https://www.oracle.com/java/technologies/javase-downloads.html)
2. **Apache Maven**: For dependency management and running the tests.
3. **IDE**: IntelliJ IDEA (or any other Java IDE).
4. **Browser Driver**: Microsoft Edge WebDriver or any browser driver you're testing against.

## Code Guidelines
- **Java Clean Code Principles**:
  - Clear, descriptive variable names.
  - Methods with a single responsibility.
  - Proper indentation and formatting.
  - Comments where necessary for better understanding.

## Steps to Run the Tests
1. Clone this repository to your local system.
2. Open the project in your preferred IDE (e.g., IntelliJ IDEA).
3. Update the `pom.xml` file to ensure all dependencies are resolved.
4. Download the appropriate browser driver (e.g., Edge WebDriver) and set the system property for the driver in the code.
   Example:
   ```java
   System.setProperty("webdriver.edge.driver", "path_to_edgedriver");
   ```
5. Configure the required plugins for reporting:
   - **Extent Report**: Ensure the extent configuration file (`extent-config.xml`) is included in the project.
   - **Allure Report**: Install the Allure Commandline and integrate it with your project.
6. To run the tests:
   - For TestNG:
     - Execute the `testng.xml` file.
   - For Cucumber (BDD):
     - Right-click on the feature file and select "Run".
7. Generate reports:
   - **Extent Report**: View the HTML report in the `test-output/ExtentReport.html` file.
   - **Allure Report**:
     - Run the following Maven command to generate Allure reports:
       ```sh
       mvn allure:serve
       ```

## Project Structure
```
src
├── main
│   ├── java
│   │   ├── pages          # Page Object Model classes
│   │   ├── utils          # Utility classes (e.g., reporting, driver setup)
│   │   └── config         # Configuration files
│   └── resources
│       └── extent-config.xml  # Extent Report configuration
├── test
│   ├── java
│   │   ├── stepDefs       # Cucumber step definition classes
│   │   ├── tests          # TestNG test cases
│   │   └── hooks          # Setup and teardown methods
│   └── resources
│       ├── features       # Cucumber feature files
│       └── testng.xml     # TestNG configuration file
```

## Example Test Case
This example demonstrates verifying a success message after a purchase:
```java
@Then("I should see a success message {string}")
public void i_should_see_a_success_message(String message) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//h2[text()='" + message + "']")));
    Assert.assertEquals(successMessage.getText(), message, "Success message verification failed.");
}
```

## Reporting
- **Extent Report**:
  - Generates a visually appealing report for test execution.
  - Configure the file location in `extent-config.xml`.

- **Allure Report**:
  - Provides a comprehensive report with detailed insights into test execution.
  - Run `mvn allure:serve` to view the report in the browser.

## Contact
For any queries or issues, feel free to contact the project maintainer.
