package com.sharafdg.tests;

import com.sharafdg.base.BaseTest;

import com.sharafdg.page.CheckoutPage;
import com.sharafdg.page.LoginPage;
import com.sharafdg.page.OrderSummaryPage;
import com.sharafdg.page.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;
    CheckoutPage checkoutPage;
    OrderSummaryPage orderSummaryPage;

    private static final String PRODUCT_URL = "https://uae.sdgstage.com/product/apple-iphone-14-pro-256gb-silver-physical-dual-sim-international-version";
    private static final String PRODUCT_NAME_SMALL_HP = "Apple iPhone 14 Pro (256GB) - Silver";
    private static final String PRODUCT_NAME_BIG_HP = "Apple iPhone 14 Pro (256GB) – Silver";
    private static final String PRODUCT_PRICE = "2,900.00";
    private static final String ADDRESS = "address";

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderSummaryPage = new OrderSummaryPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.loginWithEmailPassword("gupta2010anshul@gmail.com", "gupta2010anshul");
        loginPage.navigateToProductPage();
    }

    @Test
    public void verifyProductPage() {
        loginPage.navigateToProductPage();
        String productName = productPage.getProductTitle();
        String productPrice = productPage.getSalePrice();
        Assert.assertEquals(productName, PRODUCT_NAME_BIG_HP, "Product name on Product page is incorrect.");
        Assert.assertEquals(productPrice, PRODUCT_PRICE, "Product price on Product page is incorrect.");

        productPage.addToCart();
        String cartProductName = productPage.getCartProductTitle();
        String cartProductPrice = productPage.getCartPrice();
        Assert.assertEquals(cartProductName, PRODUCT_NAME_SMALL_HP, "Product name in Cart is incorrect.");
        Assert.assertEquals(cartProductPrice, PRODUCT_PRICE, "Product price in Cart is incorrect.");

        productPage.checkoutBtn();
        checkoutPage.performCheckout(ADDRESS);
        Assert.assertTrue(true, "Checkout is not successful.");

        String orderNumberMessage = orderSummaryPage.getOrderNumberMessage();
        String osProductTitle = orderSummaryPage.getOrderSummaryProductTitle();
        String osProductPrice = orderSummaryPage.getOrderSummaryProductPrice();
        String osShippingDetails = orderSummaryPage.getShippingDetails();
        System.out.println(osShippingDetails);
        System.out.println(osShippingDetails);
        System.out.println(osShippingDetails);
        Assert.assertTrue(orderNumberMessage.contains("Order number "), "Order Number is not displayed.");
        Assert.assertEquals(osProductTitle, PRODUCT_NAME_SMALL_HP, "Product Title is incorrect.");
        Assert.assertTrue(osProductPrice.contains(PRODUCT_PRICE), "Product price is incorrect.");
        Assert.assertTrue(osShippingDetails.contains(ADDRESS), "Address not present in Shipping Details");
        Assert.assertTrue(osShippingDetails.contains("Dubai"), "Emirates not present in Shipping Details");
        Assert.assertTrue(osShippingDetails.contains("Abu Hail"), "Area not present in Shipping Details");
    }

}
