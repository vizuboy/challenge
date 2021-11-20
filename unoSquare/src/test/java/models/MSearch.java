package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MSearch {

	WebDriver driver;
	
	@FindBy(xpath = "//*[@id='coreui-productplacement-30l7ywa_0']/div/div/span[3]/span[1]")
	private WebElement firstItem;
	@FindBy(xpath = "//*[@id='coreui-productplacement-30l7ywa_1']/div/div/span[3]/span[1]")
	private WebElement secondItem;
	@FindBy(xpath = "//*[@id='coreui-productplacement-30l7ywa_2']/div/div/span[3]/span[1]")
	private WebElement thirdItem;

	@FindBy(xpath = "//*[@id='coreui-productplacement-30l7ywa_dg7gmgf0dst3']/div/a/div[1]")
	private WebElement item;

	@FindBy(xpath = "//*[@id='R1MarketRedirect-1']/button")
	private WebElement closeModal;
	
	@FindBy(xpath = "//*[@class='close x-hidden-focus']")
	private WebElement closeModal2;

	public MSearch(WebDriver driver) {
		// initialize page factory
		PageFactory.initElements(driver, this);
	}

	public String getFirstPrice() {
		
		int position = firstItem.getText().indexOf('$');
		
		return firstItem.getText().substring(position);
	}

	public WebElement getFirstItem() {
		return firstItem;
	}

	public WebElement getSecondItem() {
		return secondItem;
	}

	public WebElement getThirdItem() {
		return thirdItem;
	}

	public void clickOnItem() {
		item.click();
	}
	
	public void clickCloseModal() {
		closeModal.click();
	}
	
	public void clickCloseModal2() {
		closeModal2.click();
	}
}