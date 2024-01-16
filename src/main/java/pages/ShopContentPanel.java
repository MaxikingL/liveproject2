package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ShopContentPanel extends BasePage {

	public WebDriver driver;
	
	By continueShoppingBtn = By.xpath("//button[contains(text(), 'Continue')]");
	By checkoutBtn = By.linkText("\uE876PROCEED TO CHECKOUT");
	
	public ShopContentPanel() throws IOException {
		this.driver = getDriver();
		this.driver = driver;
	}
	
	public WebElement getContinueShopBtn() throws IOException {
		this.driver = getDriver();
		return driver.findElement(continueShoppingBtn);
	}
	
	public WebElement getCheckoutBtn() throws IOException {
		this.driver = getDriver();
		return driver.findElement(checkoutBtn);
	}
	
}
