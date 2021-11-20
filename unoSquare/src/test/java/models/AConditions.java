package models;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AConditions {

	@FindBy(id = "helpsearch")
	private WebElement txtSearchBar;

	@FindBy(xpath = "//*[contains (text(), ' Ayuda para el Echo')]")
	private WebElement linkEchoSupport;

	public AConditions(WebDriver driver) {
		// initialize page factory
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchBar() {
		return txtSearchBar;
	}
	
	public void setSearchBar(String value) {
		txtSearchBar.sendKeys(value);
		txtSearchBar.sendKeys(Keys.RETURN);
	}

	public WebElement getLinkEchoSupport() {
		return linkEchoSupport;
	}

	public void clickEchoSupport() {
		linkEchoSupport.click();
	}
}