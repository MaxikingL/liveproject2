package uk.co.automationtesting;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.time.Duration;

@Listeners(resource.Listeners.class)
public class AddRemoveItemBasketTest extends BasePage {
    public AddRemoveItemBasketTest() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException {
        driver = getDriver();
        driver.get(getUrl());
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver = null;
    }


    @Test
    public void addRemoveItem() throws IOException {
        Homepage homepage = new Homepage(driver);
        homepage.getCookie().click();

        homepage.getTestStoreLink().click();

        ShopHomepage shopHomepage = new ShopHomepage(driver);
        shopHomepage.getProdOne().click();

        ShopProductPage shopProductPage = new ShopProductPage(driver);
        Select option = new Select(shopProductPage.getSizeOption());
        option.selectByVisibleText("M");
        shopProductPage.getQuantIncrease().click();
        shopProductPage.getAddToCartBtn().click();

        ShopContentPanel shopContentPanel = new ShopContentPanel(driver);
        shopContentPanel.getContinueShopBtn().click();
        shopProductPage.getHomepageLink().click();
        shopHomepage.getProdTwo().click();
        shopProductPage.getAddToCartBtn().click();
        shopContentPanel.getCheckoutBtn().click();

        ShoppingCart cart = new ShoppingCart(driver);
        cart.getDeleteItemTwo().click();

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.invisibilityOf(cart.getDeleteItemTwo()));

        System.out.println(cart.getTotalAmount().getText());


        Assert.assertEquals(cart.getTotalAmount().getText(),"$45.24");

    }
}
