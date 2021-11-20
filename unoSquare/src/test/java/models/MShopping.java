package models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MShopping {

	@FindBy(xpath = "//*[@id='store-cart-root']/div/div/div/section[1]/div/div/div/div/div/div[2]/div[2]/div[2]/div/span/span[2]")
	private WebElement rowPrice;

	@FindBy(xpath = "//*[@id='store-cart-root']/div/div/div/section[2]/div/div/div[1]/div/span[1]/span[2]/div/span/span[2]")
	private WebElement itemPrice;

	@FindBy(xpath = "//*[@id='store-cart-root']/div/div/div/section[2]/div/div/div[2]/div/span/span[2]/strong/span")
	private WebElement totalPrice;

	@FindBy(xpath = "//*[@id='store-cart-root']/div/div/div/section[1]/div/div/div/div/div/div[2]/div[2]/div[1]/select")
	private WebElement webSelect;

	public MShopping(WebDriver driver) {
		// initialize page factory
		PageFactory.initElements(driver, this);
	}

	public void selectAmount(String visibleText) {
		Select select = new Select(webSelect);
		select.selectByVisibleText(visibleText);
	}

	public String getPriceRow() {
		return rowPrice.getText();
	}

	public String getPriceItem() {
		return itemPrice.getText();
	}

	public String getPriceTotal() {
		return totalPrice.getText();
	}
}