package models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ARegistration {

	private WebDriver driver;

	@FindBy(id = "ap_customer_name")
	private WebElement txtName;

	@FindBy(id = "ap_email")
	private WebElement txtEmail;

	@FindBy(id = "ap_password")
	private WebElement txtPassword;

	@FindBy(id = "ap_password_check")
	private WebElement txtConfirmation;

	@FindBy(xpath = "//*[@id='legalTextRow']/a[1]")
	private WebElement linkConditions;

	public ARegistration(WebDriver driver) {
		this.driver = driver;
		// initialize page factory
		PageFactory.initElements(driver, this);
	}

	public void setName(String name) {
		txtName.sendKeys(name);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void setConfirmation(String confirmation) {
		txtConfirmation.sendKeys(confirmation);
	}

	public void clickConditions() {
		new Actions(driver).moveToElement(linkConditions).click().perform();
	}
}