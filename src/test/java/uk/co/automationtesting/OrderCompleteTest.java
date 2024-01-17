package uk.co.automationtesting;

import java.io.IOException;

import base.ExtentManager;
import base.Hooks;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.*;

@Listeners(resource.Listeners.class)
public class OrderCompleteTest extends Hooks {




	public OrderCompleteTest() throws IOException {
		super();
	}
	

	
	@Test
	public void endToEndTest() throws IOException {

		ExtentManager.log("Starting OrderCompleteTest...");

		Homepage homepage = new Homepage();
		homepage.getCookie().click();
		homepage.getTestStoreLink().click();
		ExtentManager.pass("Have successfully reached store homepage");



		ShopHomepage shopHomepage = new ShopHomepage();
		shopHomepage.getProdOne().click();
		ExtentManager.log("Have successfully clicked on product");


		ShopProductPage shopProductPage = new ShopProductPage();
		ExtentManager.log("Have successfully reached shop product page");
		Select option =new Select(shopProductPage.getSizeOption());
		option.selectByVisibleText("M");
		ExtentManager.log("Have successfully selected product size");
		shopProductPage.getQuantIncrease().click();
		ExtentManager.log("Have successfully increased quantity");
		shopProductPage.getAddToCartBtn().click();
		ExtentManager.log("Have successfully added item to cart");


		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		ShopContentPanel contentPanel = new ShopContentPanel();
		contentPanel.getCheckoutBtn().click();

		ShoppingCart shoppingCart = new ShoppingCart();
		ExtentManager.log("Have successfully reached the shopping cart page");
		shoppingCart.getHavePromo().click();
		ExtentManager.log("Have successfully selected the promo button");
		shoppingCart.getPromoTextbox().sendKeys("20OFF");
		shoppingCart.getPromoAddBtn().click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		shoppingCart.getProceedCheckoutBtn().click();
		ExtentManager.log("Have successfully selected customer details");

		OrderFormPersInfo orderFormPersInfo = new OrderFormPersInfo();
		orderFormPersInfo.getGenderMr().click();
		orderFormPersInfo.getFirstNameField().sendKeys("John");
		orderFormPersInfo.getLastnameField().sendKeys("Smith");
		orderFormPersInfo.getEmailField().sendKeys("johnsmith@test.com");
		orderFormPersInfo.getTermsConditionsCheckbox().click();
		ExtentManager.log("Have successfully entered customer details");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		orderFormPersInfo.getContinueBtn().click();

		OrderFormDelivery orderFormDelivery = new OrderFormDelivery();
		orderFormDelivery.getAddressField().sendKeys("123 Main street");
		orderFormDelivery.getCityField().sendKeys("Houston");
		Select state = new Select(orderFormDelivery.getStateDropdown());
		state.selectByVisibleText("Texas");
		orderFormDelivery.getPostcodeField().sendKeys("33443");
		ExtentManager.log("Have successfully entered delivery info");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		orderFormDelivery.getContinueBtn().click();

		OrderFormShippingMethod orderFormShippingMethod = new OrderFormShippingMethod();
		orderFormShippingMethod.getDeliveryMsgTextbox().sendKeys("If I am not in pleas leave my delivery on my porch");
		orderFormShippingMethod.getContinueBtn();
		ExtentManager.log("Have successfully selected the shipping method");


		OrderFormPayment orderFormPayment = new OrderFormPayment();
		orderFormPayment.getPayByCheckRadioBtn().click();
		orderFormPayment.getTermsConditionsCheckbox().click();
		orderFormPayment.getOrderBtn().click();
		ExtentManager.log("Have successfully placed order");










	}

}
