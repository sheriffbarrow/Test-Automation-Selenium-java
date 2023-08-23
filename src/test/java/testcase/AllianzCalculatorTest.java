package testcase;

import base.Base;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.AllianzCalculatorMethods;
import utilities.TestData;

import static utilities.AllianzCalculatorLocators.*;

public class AllianzCalculatorTest extends Base {
    private AllianzCalculatorMethods calculatorMethods;

    @Test(dataProvider = "testData", dataProviderClass = TestData.class)
    public void testCalculatePremium(String zipCode, String street, String houseNumber, String birthDate, String squareMeters) throws InterruptedException {
        // Navigate to the Allianz calculator page
        driver.get("https://hausrat.allianz.de/");

        // Initialize the Methods class
        calculatorMethods = new AllianzCalculatorMethods(driver);

        //close cookie
        calculatorMethods.closeCookieNotification(acceptCookie);

        //Open the Jetzt berechnen button
        calculatorMethods.clickElement(calculateButton);

        // Input address information
        calculatorMethods.verifyAddresspage(title);
        calculatorMethods.enterZip(zipCodeInput, zipCode);
        calculatorMethods.clickStreet(streetList, street);
        calculatorMethods.enterHouseNumber(houseNumberInput, houseNumber);
        calculatorMethods.enterDateofBirth(dob, birthDate);
        calculatorMethods.enterSquareMeters(squareMeteres, squareMeters);
        calculatorMethods.einfamilienhaus(einfamilienhaus);
        calculatorMethods.nein(nein);

        //Click on the calculate button
        calculatorMethods.calculateInputs(calculateBttn);

        calculatorMethods.verifyModuleSelectionPage();
        // Wait for the premium calculation result to be displayed
        String calculatedPremium = calculatorMethods.getCalculatedPremium(premiumAmount);

        // Verify that the calculated premium amount is in EUR/€
        Assert.assertTrue(calculatedPremium.contains("EUR") || calculatedPremium.contains("€"),
                "Calculated premium amount should be in EUR/€ format.");
    }


}
