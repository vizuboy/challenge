package models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AHome {

	private WebDriver driver;

	@FindBy(xpath = "//*[@id='nav-link-accountList-nav-line-1']")
	private WebElement linkSign;

	@FindBy(xpath = "//*[@id='nav-flyout-ya-newCust']/a")
	private WebElement startHere;

	public AHome(WebDriver driver) {
		this.driver = driver;
		// initialize page factory
		PageFactory.initElements(driver, this);
	}

	public WebElement getLinkSign() {
		return linkSign;
	}
	
	public void posCursorOverLink() {
		new Actions(driver).moveToElement(linkSign).perform();
	}

	public void clickStartHere() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(startHere));

		startHere.click();
	}
}