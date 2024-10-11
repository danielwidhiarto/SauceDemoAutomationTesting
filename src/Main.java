import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Java Library\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        try {
            // 1. Open SauceDemo website
            driver.get("https://www.saucedemo.com/");

            // 2. Log in
            WebElement username = driver.findElement(By.id("user-name"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("login-button"));

            username.sendKeys("standard_user");
            password.sendKeys("secret_sauce");
            loginButton.click();

            // 3. Add a random product to the cart
            List<WebElement> addToCartButtons = driver.findElements(By.className("btn_inventory"));
            Random random = new Random();
            int randomProduct = random.nextInt(addToCartButtons.size());
            addToCartButtons.get(randomProduct).click();

            // 4. Go to the cart
            WebElement cart = driver.findElement(By.id("shopping_cart_container"));
            cart.click();

            // 5. Verify the cart contents
            WebElement cartItem = driver.findElement(By.className("inventory_item_name"));
            if (cartItem != null) {
                System.out.println("Item successfully added to the cart: " + cartItem.getText());
            } else {
                System.out.println("No items in the cart.");
            }

            // 6. Take a screenshot of the cart page with a timestamp
            takeScreenshot(driver, "cart_screenshot");

            // 7. Proceed to checkout
            WebElement checkoutButton = driver.findElement(By.id("checkout"));
            checkoutButton.click();

            // 8. Fill in checkout details
            WebElement firstName = driver.findElement(By.id("first-name"));
            WebElement lastName = driver.findElement(By.id("last-name"));
            WebElement postalCode = driver.findElement(By.id("postal-code"));

            firstName.sendKeys("John");
            lastName.sendKeys("Doe");
            postalCode.sendKeys("12345");

            WebElement continueButton = driver.findElement(By.id("continue"));
            continueButton.click();

            // 9. Take another screenshot at the checkout overview page with a timestamp
            takeScreenshot(driver, "checkout_overview_screenshot");

            // 10. Log out
            WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
            menuButton.click();
            Thread.sleep(250); // wait for the menu to appear

            WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
            logoutLink.click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    // Method to take screenshots with a timestamp
    public static void takeScreenshot(WebDriver driver, String fileName) {
        // Generate a timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filePath = "D:/SS/" + fileName + "_" + timestamp + ".png";

        try {
            FileUtils.copyFile(screenshot, new File(filePath));
            System.out.println("Screenshot taken: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
