package com.sharafdg.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//button[@class='w-100 justify-content-center add_to_cart_button ajax_add_to_cart button btn btn-primary alt videoly-atc-btn']")
    WebElement addToCartButton;

    @FindBy(xpath = "//span[@class='total--sale-price']")
    WebElement salePrice;

    @FindBy(className = "checkout-button")
    WebElement checkoutButton;

    @FindBy(className = "product_title")
    WebElement productTitle;

    @FindBy(xpath = "//div[@class='product-name']//span")
    WebElement cartProductTitle;

    @FindBy(xpath = "//div[@class='d-flex py-3 justify-content-between cart-total']//span[@class='value']//span[@class='amount']")
    WebElement cartPrice;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductTitle() {
        return waitUntilElementVisible(productTitle).getText();
    }

    public String getSalePrice() {
        return waitUntilElementVisible(salePrice).getText();
    }

    public void addToCart() {waitUntilElementVisible(addToCartButton).click();
    }

    public void checkoutBtn() {waitUntilElementVisible(checkoutButton).click();}

    public String getCartProductTitle() {return waitUntilElementVisible(cartProductTitle).getText();}

    public String getCartPrice() {return waitUntilElementVisible(cartPrice).getText();}

}
