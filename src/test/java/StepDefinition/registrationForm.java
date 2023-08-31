package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class registrationForm {
    private WebDriver driver;

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
        System.setProperty("webdriver.crome.driver", "driver/cromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @When("I enter the student's first name {string}and last name {string}")
    public void iEnterTheStudentSFirstNameAndLastName(String firstName, String lastName) {
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
    }

    @And("I enter the student's email {string}")
    public void iEnterTheStudentSEmail(String email) {
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(email);
    }

    @And("I select the student's gender as {string}")
    public void iSelectTheStudentSGenderAs(String gender) {
        driver.findElement(By.xpath("//label[.='Male']")).click();
        String radioButton1 = driver.findElement(By.xpath("//label[.='Male']")).getText();
        System.out.println(radioButton1);

        //Validate Value
        try {
            Assert.assertEquals(gender,radioButton1);
        }catch (Exception e){
            Assert.fail("Fail - Error Not Match");
            System.out.println(radioButton1);
            System.out.println(e);
        }
    }

    @And("I enter the student's  mobile phone number {string}")
    public void iEnterTheStudentSMobilePhoneNumber(String mPhoneNumber) {
        driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys(mPhoneNumber);
    }

    @SneakyThrows
    @And("I enter the student's date of birth {string}")
    public void iEnterTheStudentSDateOfBirth(String dob) {
        WebElement dobElemet = driver.findElement(By.id("dateOfBirthInput"));
        dobElemet.clear();
        //WebElement dobScript = driver.findElement(By.xpath("(//input[@id='dateOfBirthInput']"));
        //dobScript.isEnabled();
        //JavascriptExecutor jse = (JavascriptExecutor)driver;
        //jse.executeScript("arguments[0].click()", dobScript);

        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
        selectMonth.selectByValue("7");
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
        selectYear.selectByValue("1999");
        driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--011']")).click();

        String currentDob = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).getText();
        System.out.println(currentDob+"CD");

        //Thread.sleep(5000);
        //Validate Value
       /* try{
            Assert.assertEquals(currentDob,dob);
        }catch (Exception e){
            System.out.println(currentDob);
            System.out.println(e);
        }*/
    }

    @SneakyThrows
    @And("I enter the student's Subject {string}")
    public void iEnterTheStudentSSubject(String subject) {
        WebElement subjectElement = driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']"));
        subjectElement.sendKeys(subject);
        Thread.sleep(2000);
        subjectElement.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        subjectElement.sendKeys(Keys.ENTER);
    }

    @And("I select the student's Hobbies as {string}")
    public void iSelectTheStudentSHobbiesAs(String hobbies) {
        driver.get("");
    }

    @And("I select the student's picture for school documentation")
    public void iSelectTheStudentSPictureForSchoolDocumentation() {
        driver.get("");
    }

    @And("I provide the student's address {string}")
    public void iProvideTheStudentSAddress(String address) {
        driver.get("");
    }

    @And("I select the student's state and city")
    public void iSelectTheStudentSStateAndCity() {
        driver.get("");
    }

    @And("I click the submit button")
    public void iClickTheSubmitButton() {
        driver.get("");
    }

    @Then("I should see a success popup message {string}")
    public void iShouldSeeASuccessPopupMessage(String successMessage) {
        driver.get("");
    }
}
