package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class loginTest {

    private WebDriver driver;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        System.setProperty("webdriver.crome.driver", "driver/cromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window();
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter valid username {string} and valid password {string}")
    public void iEnterValidUsernameAndValidPassword(String validUsername, String validPassword) {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(validUsername);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(validPassword);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }


    @When("I enter valid username {string} and incorrect password {string}")
    public void iEnterValidUsernameAndIncorrectPassword(String validUsername, String wrongPassword) {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(validUsername);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(wrongPassword);
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String errorMessage1) {
        String currentErrorMessage1 = driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText();
        System.out.println(currentErrorMessage1);

        try {
            Assert.assertEquals(errorMessage1,currentErrorMessage1);
        }catch (Exception e){
            Assert.fail("Fail - Error Message Not Match");
            System.out.println(currentErrorMessage1);
            System.out.println(e);
        }
        driver.quit();
    }

    @When("I enter non-existing username {string} and valid password {string}")
    public void iEnterNonExistingUsernameAndValidPassword(String nonExistingUsername, String validPassword) {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(nonExistingUsername);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(validPassword);
    }

    @When("I enter empty username and password {string}")
    public void iEnterEmptyUsernameAndPassword(String validPassword) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(validPassword);
    }

    @When("I enter non-existing username {string} and empty password")
    public void iEnterNonExistingUsernameAndEmptyPassword(String validUsername) {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(validUsername);
    }

    @When("I enter empty username and empty password")
    public void iEnterEmptyUsernameAndEmptyPassword() {
    }

    @Then("I should be successfully logged in and direct to {string}")
    public void iShouldBeSuccessfullyLoggedInAndDirectTo(String urlDashboard) {
        String currentURL = driver.getCurrentUrl();
        //System.out.println(currentURL);
        try {
            Assert.assertEquals(urlDashboard,currentURL);
        }catch (Exception e){
            Assert.fail("Fail - Url Not Match");
            System.out.println(currentURL);
            System.out.println(e);
        }
        driver.quit();
    }
}
