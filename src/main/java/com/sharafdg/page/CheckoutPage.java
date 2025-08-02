package com.sharafdg.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="(//div[contains(@class, 'selectize-input') and contains(@class, 'has-options')])[1]")
    WebElement emiratesDropdown;

    @FindBy(xpath = "(//div[@class='selectize-dropdown-content'])[1]")
    WebElement emiratesDropdownContent;

    @FindBy(xpath="(//div[@class='selectize-dropdown-content'])[1]//div[@data-value='DXB']")
    WebElement dubaiEmiratesToSelect;

    @FindBy(xpath = "(//div[@class='selectize-input items has-options full has-items'])[1]//div[@class='item']")
    WebElement selectedEmirate;

    @FindBy(xpath="(//div[contains(@class, 'selectize-input') and contains(@class, 'items')])[2]")
    WebElement areaDropdown;

    @FindBy(xpath = "(//div[@class='selectize-dropdown-content'])[2]")
    WebElement areaDropdownContent;

    @FindBy(xpath="(//div[@class='selectize-dropdown-content'])[2]//div[@data-value='ABU_HAIL']")
    WebElement abuHailAreaToSelect;

    @FindBy(xpath = "(//div[@class='selectize-input items has-options full has-items'])[2]//div[@class='item']")
    WebElement selectedArea;

    @FindBy(id = "shipping_address_1")
    WebElement addressInput;

    @FindBy(xpath="//input[@id='payment_method_cod']")
    WebElement codRadioButton;

    @FindBy(id = "place_order")
    WebElement placeOrderButton;

    private void selectDubaiForEmiratesDropdown() {
        waitUntilElementVisible(emiratesDropdown).click();
        waitUntilElementVisible(emiratesDropdownContent);
        waitUntilElementVisible(dubaiEmiratesToSelect).click();
    }

    public String selectedEmirate() {
        return waitUntilElementVisible(selectedEmirate).getText();
    }

    private void selectAbuHailForAreaDropdown() {
        waitUntilElementVisible(areaDropdown).click();
        waitUntilElementVisible(areaDropdownContent);
        waitUntilElementVisible(abuHailAreaToSelect).click();
    }

    public String selectedArea() {
        return waitUntilElementVisible(selectedArea).getText();
    }

    private void enterAddress(String address) {
        waitUntilElementVisible(addressInput).sendKeys(address);
    }

    public void performCheckout(String address) {
        enterAddress(address);
        selectDubaiForEmiratesDropdown();
        selectAbuHailForAreaDropdown();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitUntilElementVisible(codRadioButton).click();
        waitUntilElementVisible(placeOrderButton).click();
    }
}
