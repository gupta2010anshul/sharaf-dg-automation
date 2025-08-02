package com.sharafdg.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

abstract class BasePage {

    @FindBy(className = "signin-text")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    private WebElement createAccountButton;

    @FindBy(partialLinkText = "Logout")
    private WebElement logoutButton;

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        System.out.println("BasePage initiaze");
        this.driver = driver;
        System.out.println("driver initiazed " + (this.driver == null));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("wait initiazed " + (this.wait == null));
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Waits until a specific WebElement is visible on the page.
     * This is useful if you already have a WebElement object.
     *
     * @param element The WebElement to wait for.
     * @return The visible WebElement.
     */
    public WebElement waitUntilElementVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void hoverTo(WebElement element) {
        actions.moveToElement(element).perform();
    }

    public void navigateToHomePage() {
        driver.navigate().to("https://uae.sdgstage.com/");
    }

    public void navigateToLoginPage() {
        navigateToHomePage();
        waitUntilElementVisible(signInButton).click();
    }

    public String getTextOfElementByStringXpath(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public void navigateToRegistrationPage() {
        navigateToLoginPage();
        waitUntilElementVisible(createAccountButton).click();
    }

    public void navigateToProductPage() {
        driver.navigate().to("https://uae.sdgstage.com/product/apple-iphone-14-pro-256gb-silver-physical-dual-sim-international-version/");
    }

    public void clickLogoutButton() {
        waitUntilElementVisible(logoutButton).click();
    }

    private void hoverOnSignInButton() {
        WebElement signInBtn = waitUntilElementVisible(signInButton);
        hoverTo(signInBtn);
    }

    public void logout() {
        hoverOnSignInButton();
        clickLogoutButton();
    }

    public void addWaitForTenSeconds() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
