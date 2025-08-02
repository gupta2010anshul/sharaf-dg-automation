package com.sharafdg.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderSummaryPage extends BasePage {

    @FindBy(xpath="//p[@class='confirm-desc']")
    WebElement orderNumberMessage;

    @FindBy(xpath="//div[@class='product-details']//p")
    WebElement orderSummaryProductTitle;

    @FindBy( className= "woocommerce-Price-amount")
    WebElement orderSummaryProductPrice;

    @FindBy(xpath = "//div[@class='shipping box']")
    WebElement shippingDetails;

    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }

    public String getOrderNumberMessage() {
        return orderNumberMessage.getText();
    }

    public String getOrderSummaryProductTitle() {
        return orderSummaryProductTitle.getText();
    }

    public String getOrderSummaryProductPrice() {
        return orderSummaryProductPrice.getText();
    }

    public String getShippingDetails() {
        return shippingDetails.getText();
    }




}
