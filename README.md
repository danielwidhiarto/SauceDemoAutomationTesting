# SauceDemo E-Commerce Automation Testing

## Overview
This project is an automated testing suite for SauceDemo's e-commerce platform, built using Selenium WebDriver and Java. It tests the essential functionalities of the site, including login, adding items to the cart, and checking out.

## Tools & Technologies
- **Selenium WebDriver**: For browser automation.
- **Java**: Programming language.
- **JUnit/TestNG**: Test framework.
- **Maven**: Dependency management.
- **ExtentReports**: For generating test reports.

## Prerequisites
1. Install Java (JDK 8+).
2. Install Maven.
3. Install a preferred IDE (IntelliJ, Eclipse).

## Setup
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/saucedemo-automation-testing.git
    ```
2. Navigate to the project directory and build it with Maven:
    ```bash
    mvn clean install
    ```

3. Set up WebDriver:
    - ChromeDriver or GeckoDriver for Firefox.

## Running the Tests
- Run all tests using Maven:
    ```bash
    mvn test
    ```
- Test results will be available in the `/reports` folder.

## Test Scenarios
- **Login:** Tests valid and invalid login attempts.
- **Cart Functionality:** Tests adding and removing items from the cart.
- **Checkout:** Verifies the checkout process, including form validation and submission.

## Test Report
Generated reports can be found in the `/reports` directory or by executing the following Maven command:
```bash
mvn test -DgenerateReport=true
