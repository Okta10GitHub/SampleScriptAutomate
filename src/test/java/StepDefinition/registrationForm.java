package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class registrationForm {
    private WebDriver driver;
    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
        System.setProperty("webdriver.crome.driver", "driver/cromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
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

        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
        selectMonth.selectByValue("7");
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
        selectYear.selectByValue("1999");
        driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--011']")).click();

        String valCurrentDob = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).getAttribute("value");
        System.out.println(valCurrentDob);

        //Validate Value
       try{
            Assert.assertEquals(valCurrentDob,dob);
        }catch (Exception e){
            System.out.println(valCurrentDob);
            System.out.println(e);
        }
    }

    @SneakyThrows
    @And("I enter the student's Subject {string}")
    public void iEnterTheStudentSSubject(String subject) {
        WebElement subjectElement = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(subjectElement)).sendKeys(subject);
        Thread.sleep(1000);
        subjectElement.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        subjectElement.sendKeys(Keys.ENTER);

        String subjectLabel = driver.findElement(By.xpath("//div[@class='css-12jo7m5 subjects-auto-complete__multi-value__label']")).getText();
        System.out.println(subjectLabel);
        Thread.sleep(2000);
        try{
            Assert.assertEquals(subjectLabel,subject);
        }catch (Exception e){
            System.out.println(subjectLabel);
            System.out.println(e);
        }

    }

    @SneakyThrows
    @And("I select the student's Hobbies as {string}")
    public void iSelectTheStudentSHobbiesAs(String hobbies) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        WebElement chkHobbies = driver.findElement(By.xpath("//label[normalize-space()='Sports']"));
        Thread.sleep(2000);
        chkHobbies.click();
        String hobbiesLabel = chkHobbies.getText();
        System.out.println(hobbiesLabel);
        Thread.sleep(2000);
        try{
            Assert.assertEquals(hobbiesLabel,hobbies);
        }catch (Exception e){
            System.out.println(chkHobbies);
            System.out.println(e);
        }
    }

    @And("I select the student's picture for school documentation")
    public void iSelectTheStudentSPictureForSchoolDocumentation() {
        driver.findElement(By.xpath("//input[@id='uploadPicture']"))
                .sendKeys("C:\\Users\\moktaviansyah\\Pictures\\testing.jpg");
    }

    @And("I provide the student's address {string}")
    public void iProvideTheStudentSAddress(String address) {
        driver.findElement(By.xpath("//textarea[@id='currentAddress']"))
                .sendKeys(address);
    }

    @SneakyThrows
    @And("I select the student's state and city")
    public void iSelectTheStudentSStateAndCity() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='65%'");
        Thread.sleep(2000);

        //STATE
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(state)).sendKeys("n");
        Thread.sleep(1000);
        state.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        state.sendKeys(Keys.ENTER);

        //CITY
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(city)).sendKeys("Panipat");
        Thread.sleep(1000);
        city.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        city.sendKeys(Keys.ENTER);

        //Validate Value
        String valCurrentState = driver.findElement(By.xpath("//div[@id='state']//div[@class=' css-1uccc91-singleValue']")).getText();
        String valCurrentCity = driver.findElement(By.xpath("//div[@id='city']//div[@class=' css-1uccc91-singleValue']")).getText();
        System.out.println(valCurrentState);
        System.out.println(valCurrentCity);

        try{
            Assert.assertEquals(valCurrentState,"Haryana");
            Assert.assertEquals(valCurrentCity,"Panipat");
        }catch (Exception e){
            System.out.println(valCurrentState);
            System.out.println(valCurrentCity);
            System.out.println(e);
        }
    }

    @And("I click the submit button")
    public void iClickTheSubmitButton() {
        new WebDriverWait(driver,Duration.ofSeconds(60))
                .until(ExpectedConditions.elementToBeClickable(By.id("submit"))).submit();
    }

    @Then("I should see a success popup message {string}")
    public void iShouldSeeASuccessPopupMessage(String successMessage) {
        String messagePopup1 = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
        System.out.println(messagePopup1);

        try{
            Assert.assertEquals(messagePopup1,successMessage);
        }catch (Exception e){
            System.out.println(messagePopup1);
            System.out.println(e);
        }
    }
}
