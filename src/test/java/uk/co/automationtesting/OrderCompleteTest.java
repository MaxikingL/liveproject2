package uk.co.automationtesting;

import java.io.IOException;

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
		Homepage homepage = new Homepage();
		homepage.getCookie().click();
		homepage.getTestStoreLink().click();


		ShopHomepage shopHomepage = new ShopHomepage();
		shopHomepage.getProdOne().click();

		ShopProductPage shopProductPage = new ShopProductPage();
		Select option =new Select(shopProductPage.getSizeOption());
		option.selectByVisibleText("M");
		shopProductPage.getQuantIncrease().click();
		shopProductPage.getAddToCartBtn().click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		ShopContentPanel contentPanel = new ShopContentPanel();
		contentPanel.getCheckoutBtn().click();

		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.getHavePromo().click();
		shoppingCart.getPromoTextbox().sendKeys("20OFF");
		shoppingCart.getPromoAddBtn().click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		shoppingCart.getProceedCheckoutBtn().click();

		OrderFormPersInfo orderFormPersInfo = new OrderFormPersInfo();
		orderFormPersInfo.getGenderMr().click();
		orderFormPersInfo.getFirstNameField().sendKeys("John");
		orderFormPersInfo.getLastnameField().sendKeys("Smith");
		orderFormPersInfo.getEmailField().sendKeys("johnsmith@test.com");
		orderFormPersInfo.getTermsConditionsCheckbox().click();
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
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		orderFormDelivery.getContinueBtn().click();

		OrderFormShippingMethod orderFormShippingMethod = new OrderFormShippingMethod();
		orderFormShippingMethod.getDeliveryMsgTextbox().sendKeys("If I am not in pleas leave my delivery on my porch");
		orderFormShippingMethod.getContinueBtn();

		OrderFormPayment orderFormPayment = new OrderFormPayment();
		orderFormPayment.getPayByCheckRadioBtn().click();
		orderFormPayment.getTermsConditionsCheckbox().click();
		orderFormPayment.getOrderBtn().click();









	}

}
