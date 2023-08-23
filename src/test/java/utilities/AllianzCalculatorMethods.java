package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static java.lang.Thread.sleep;


public class AllianzCalculatorMethods {
    private WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    public AllianzCalculatorMethods(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get the calculated premium amount
    public String getCalculatedPremium(By locator) {
        WebElement premiumAmountElement = driver.findElement(locator);
        return premiumAmountElement.getText();
    }

    //Method to close cookie
    public void closeCookieNotification(By locator) {
        try {
            // Check if the cookie notification element is present
            WebElement cookieNotification = driver.findElement(locator);

            // Close the cookie notification if present
            if (cookieNotification.isDisplayed()) {
                WebElement closeButton = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
                closeButton.click();
                sleep(2000);
            }
        } catch (Exception e) {
            // Cookie notification not present or error occurred while closing, ignore
        }
    }

    // Methods for user interactions (clicks, inputs, etc.)
    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    //Very address page title
    public void verifyAddresspage(By locator){
        String expected = driver.getTitle();
        String actual =  driver.findElement(locator).getText().trim();
        softAssert.assertEquals(actual, expected, "title verification failed");
        System.out.println("address actual: " + actual);
        System.out.println("address expected: " + expected);
    }

    //Assertion methods
    public void verifyModuleSelectionPage(){
        String expected = "Hausratversicherung berechnen: ab 2,88€/mtl. | Allianz";
        String actual =  driver.getTitle();
        softAssert.assertEquals(actual, expected, "title verification failed");
        softAssert.assertAll();
    }
    public void enterZip(By locator, String text) throws InterruptedException {
        driver.findElement(locator).sendKeys(text);
        sleep(3000);
    }

    public void clickStreet(By locator, String text) throws InterruptedException {
        int counter = 0;
        driver.findElement(locator).click();
        sleep(2000);
        driver.findElement(By.xpath("//input[contains(@class,'nx-dropdown__filter-input')]")).sendKeys(text);
        sleep(2000);
        List<WebElement> suggestList = driver.findElements(By.xpath("//div[contains(@class,'nx-dropdown-results__option')]"));
        for(WebElement street : suggestList){
            String streetInput = street.getText();
            if(streetInput.contains(text)){
                street.click();
                counter++;
                break;
            }
        }
        if(counter!=0){
            System.out.println(text + " has been selected");
        }else{
            System.out.println("The option you provided is not available");
        }
    }

    public void einfamilienhaus(By locator) throws InterruptedException {
        driver.findElement(locator).click();
        sleep(1000);
    }

    public void nein(By locator) throws InterruptedException {
        driver.findElement(locator).click();
        sleep(1000);
    }

    public void enterHouseNumber(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    public void enterDateofBirth(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    public void enterSquareMeters(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    public void calculateInputs(By locator){
        driver.findElement(locator).click();
    }

}

