package uk.co.automationtesting;
import base.ExtentManager;
import base.Hooks;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

@Listeners(resource.Listeners.class)
public class AddRemoveItemBasketTest extends Hooks {

    public AddRemoveItemBasketTest() throws IOException {
        super();
    }




    @Test
    public void addRemoveItem() throws IOException {

        ExtentManager.log("Starting AddRemoveItemBasketTest...");
        Homepage homepage = new Homepage();
        homepage.getCookie().click();

        homepage.getTestStoreLink().click();

        ShopHomepage shopHomepage = new ShopHomepage();
        ExtentManager.pass("Reached the shop homepage");
        shopHomepage.getProdOne().click();


        ShopProductPage shopProductPage = new ShopProductPage();
        ExtentManager.pass("Reached the shop product page");
        Select option = new Select(shopProductPage.getSizeOption());
        option.selectByVisibleText("M");
        ExtentManager.pass("Have successfully selected product size");
        shopProductPage.getQuantIncrease().click();
        ExtentManager.pass("Have successfully increased quantity");
        shopProductPage.getAddToCartBtn().click();
        ExtentManager.pass("Have successfully added product to basket");


        ShopContentPanel shopContentPanel = new ShopContentPanel();
        shopContentPanel.getContinueShopBtn().click();
        shopProductPage.getHomepageLink().click();
        shopHomepage.getProdTwo().click();
        shopProductPage.getAddToCartBtn().click();
        shopContentPanel.getCheckoutBtn().click();

        ShoppingCart cart = new ShoppingCart();
        cart.getDeleteItemTwo().click();

        waitForElementInvisible(cart.getDeleteItemTwo(),10);

        System.out.println(cart.getTotalAmount().getText());

        try{
            Assert.assertEquals(cart.getTotalAmount().getText(),"$45.24");
ExtentManager.pass("The total amount matches the expected amount");
        }catch (AssertionError e){
            Assert.fail("Cart did not match the expected amount, it found"+ cart.getTotalAmount().getText()+
                    "exoected 45,23");
            ExtentManager.fail("The total amount did not expected amount");
        }

    }
}
