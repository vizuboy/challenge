package models;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MWindows {

	WebDriver driver;

	@FindBy(xpath = "//*[@id='c-shellmenu_56']")
	private WebElement mnuWindows10;

	@FindBy(id = "search")
	private WebElement btnSearch;

	@FindBy(id = "cli_shellHeaderSearchInput")
	private WebElement txtSearch;

	public MWindows(WebDriver driver) {
		this.driver = driver;
		// initialize page factory
		PageFactory.initElements(driver, this);
	}

	public void clickWindows10() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(mnuWindows10));
		mnuWindows10.click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='uhf-navbtn-c-shellmenu_63-button']"))));
		driver.findElement(By.xpath("//*[@id='uhf-navbtn-c-shellmenu_63-button']")).click();
	}

	public List<String> getItems() {
		List<String> strItems = new ArrayList<String>();
		for (int pos = 1; pos <= 4; pos++) {
			strItems.add(
					driver.findElement(By.xpath("//*[@id='uhf-g-nav']/ul/li[2]/div/ul/li[2]/ul[\" + pos + \"]")).getText());
		}
		return strItems;
	}

	public void clickSearch() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(btnSearch));
		btnSearch.click();
	}

	public void setTextSearch(String value) {
		txtSearch.sendKeys(value);
	}
}