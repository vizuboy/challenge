package models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MHome {

	@FindBy(xpath = "//*[@id='shellmenu_21']")
	private WebElement mnuOffice;
	@FindBy(xpath = "//*[@id='shellmenu_2']")
	private WebElement mnuWindows;
	@FindBy(xpath = "//*[@id='shellmenu_3']")
	private WebElement mnuSurface;
	@FindBy(xpath = "//*[@id='shellmenu_4']")
	private WebElement mnuXbox;
	@FindBy(xpath = "//*[@id='shellmenu_0']")
	private WebElement mnuDeals;
	@FindBy(xpath = "//*[@id='l1_support']")
	private WebElement mnuSupport;

	public MHome(WebDriver driver) {
		// initialize page factory
		PageFactory.initElements(driver, this);
	}

	public WebElement getMnuOffice() {
		return mnuOffice;
	}

	public WebElement getMnuWindows() {
		return mnuWindows;
	}

	public WebElement getMnuSurface() {
		return mnuSurface;
	}

	public WebElement getMnuXbox() {
		return mnuXbox;
	}

	public WebElement getMnuDeals() {
		return mnuDeals;
	}

	public WebElement getMnuSupport() {
		return mnuSupport;
	}

	public void clickWindowsMenu() {
		mnuWindows.click();
	}

}