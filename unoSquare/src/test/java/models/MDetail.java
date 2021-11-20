package models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MDetail {

	@FindBy(id = "productPrice")
	private WebElement price;

	@FindBy(xpath = "//*[@class='buy-box-buy-buttons mb-3']/div/a")
	private WebElement addCart;
	
	@FindBy(xpath = "//*[@id='emailSup-modal']/div/div/div/button")
	private WebElement closeModal;
	
	@FindBy(xpath = "//*[@class='close geo-selector-localized-copy preferred-redirect-cancel']")
	private WebElement closeModal2;
	
	public MDetail(WebDriver driver) {
		// initialize page factory
		PageFactory.initElements(driver, this);
	}
	
	public String getPrice() {
		return price.getText();
	}
	
	public void clickAddCart() {
		addCart.click();
	}
	
	public void clickCloseModal() {
		closeModal.click();
	}
	
	public void clickCloseModal2() {
		closeModal2.click();
	}
}