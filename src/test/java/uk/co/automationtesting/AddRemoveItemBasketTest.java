package uk.co.automationtesting;
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
        Homepage homepage = new Homepage();
        homepage.getCookie().click();

        homepage.getTestStoreLink().click();

        ShopHomepage shopHomepage = new ShopHomepage();
        shopHomepage.getProdOne().click();

        ShopProductPage shopProductPage = new ShopProductPage();
        Select option = new Select(shopProductPage.getSizeOption());
        option.selectByVisibleText("M");
        shopProductPage.getQuantIncrease().click();
        shopProductPage.getAddToCartBtn().click();

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


        Assert.assertEquals(cart.getTotalAmount().getText(),"$45.24");

    }
}
