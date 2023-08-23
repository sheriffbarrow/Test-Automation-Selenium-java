package utilities;

import org.openqa.selenium.By;

public class AllianzCalculatorLocators {
    // Locators
    public static final By acceptCookie = By.xpath("//*[@id=\"onetrust-group-container\"]");
    public static final By calculateButton = By.xpath("//*[@id=\"Content_LeadIn::Button::Jetzt-berechnen\"]");
    public static final By zipCodeInput = By.id("nx-input-0");
    public static final By streetList = By.xpath("//div[contains(@class,'nx-dropdown__container')]");
    public static final By houseNumberInput = By.id("nx-input-3");
    public static final By einfamilienhaus = By.xpath("//*[@id=\"nx-radio-6-label\"]/div");
    public static final By nein = By.xpath("//*[@id=\"nx-radio-5-label\"]/div");
    public static final By dob = By.id("nx-input-2");
    public static final By squareMeteres = By.id("nx-input-1");
    public static final By title = By.xpath("/html/head/title");
    public static final By premiumAmount = By.xpath("\"//span[@class='premium-amount']\"");
    public static final By closeCookieButton = By.xpath("\"//*[@id=\\\"onetrust-accept-btn-handler\\\"]\"");
    public static final By moduleTitle = By.xpath("/html/head/title");
    public static final By is = By.xpath("//*[@id=\"nx-dropdown-rendered-0\"]");
    public static final By calculateBttn = By.xpath("//*[@id=\"app\"]/main/page-data/div/div[2]/form/div/div/div[3]/button");
    public static final By claimsNoOption = By.xpath("//label[text()='Nein']/input");
}
