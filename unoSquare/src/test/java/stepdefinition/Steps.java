package stepdefinition;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import models.AConditions;
import models.AEchoSupport;
import models.AHome;
import models.ARegistration;
import models.MDetail;
import models.MHome;
import models.MSearch;
import models.MShopping;
import models.MWindows;
import models.Util;

public class Steps {

	private WebDriver driver;
	private String firstPrice;

	private HashMap<String, String> dataProvided;

	@Given("^the user is on the windows home page$")
	public void the_user_is_on_the_windows_home_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to(Config.baseWindowsURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@And("^validate that all menu items are present$")
	public void validate_that_all_menu_items_are_present() {
		MHome home = new MHome(driver);

		Assert.assertNotNull(home.getMnuOffice());
		Util.highLighterMethod(driver, home.getMnuOffice());
		Assert.assertNotNull(home.getMnuWindows());
		Util.highLighterMethod(driver, home.getMnuWindows());
		Assert.assertNotNull(home.getMnuSurface());
		Util.highLighterMethod(driver, home.getMnuSurface());
		Assert.assertNotNull(home.getMnuXbox());
		Util.highLighterMethod(driver, home.getMnuXbox());
		Assert.assertNotNull(home.getMnuDeals());
		Util.highLighterMethod(driver, home.getMnuDeals());
		Assert.assertNotNull(home.getMnuSupport());
		Util.highLighterMethod(driver, home.getMnuSupport());

		home.clickWindowsMenu();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException ie) {
		}
	}

	@And("^print all elements in dropdown from windows page$")
	public void print_all_elements_in_dropdown_from_windows_page() {
		MWindows windows = new MWindows(driver);
		windows.clickWindows10();
		System.out.println(windows.getItems().toString());
	}

	@When("^the user search \"([^\"]*)\"$")
	public void the_user_search(String search) {
		MWindows windows = new MWindows(driver);

		windows.clickSearch();
		windows.setTextSearch(search);
		windows.clickSearch();

	}

	@And("^click the first one$")
	public void click_the_first_one() {
		MSearch mSearch = new MSearch(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {
			mSearch.clickCloseModal();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@href='/en-us/search/shop?q=Visual Studio']"))));
		driver.findElement(By.xpath("//*[@href='/en-us/search/shop?q=Visual Studio']")).click();
		
		try {
			mSearch.clickCloseModal();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		firstPrice = mSearch.getFirstPrice();
		mSearch.clickOnItem();
	}

	@And("^add to the cart, select \"([^\"]*)\"$")
	public void add_to_the_cart_select(String amount) {
		MDetail detail = new MDetail(driver);

		/*try {
			detail.clickCloseModal2();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ie) {
		}
		
		try {
			detail.clickCloseModal();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Assert.assertEquals(firstPrice, detail.getPrice());

		detail.clickAddCart();

		MShopping shopping = new MShopping(driver);

		Assert.assertEquals(firstPrice, shopping.getPriceRow());
		Assert.assertEquals(firstPrice, shopping.getPriceItem());
		Assert.assertEquals(firstPrice, shopping.getPriceTotal());

		shopping.selectAmount(amount);

	}

	@Then("^the user validate the correct price$")
	public void the_user_validate_the_correctprice() {
		MShopping shopping = new MShopping(driver);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException ie) {
		}

		double bigFirst = Double.parseDouble(firstPrice.substring(1).replaceAll(",", ""));
		double bigTotal = Double.parseDouble(shopping.getPriceTotal().substring(1).replaceAll(",", ""));

		double result = bigFirst * 20;

		Assert.assertEquals(bigTotal, result, 0);
	}

	@Given("^the user is on Amazon page$")
	public void the_user_is_on_Amazon_page() {
		dataProvided = Config.getData();

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to(Config.baseAmazonURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the user create and account$")
	public void the_user_create_and_account() {
		AHome home = new AHome(driver);

		Assert.assertNotNull(home.getLinkSign());
		Util.highLighterMethod(driver, home.getLinkSign());
		home.posCursorOverLink();
		home.clickStartHere();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ARegistration registration = new ARegistration(driver);

		String name = dataProvided.get("employee_name").split(" ")[0];
		String lastname = dataProvided.get("employee_name").split(" ")[1];
		String email = name + "." + lastname + "@fake.com";

		registration.setName(dataProvided.get("employee_name"));
		registration.setEmail(email);
		registration.setPassword(Config.generalPassword);
		registration.setConfirmation(Config.generalPassword);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		registration.clickConditions();
	}

	@And("^search for \"([^\"]*)\" support$")
	public void search_for_support(String search) {
		AConditions conditions = new AConditions(driver);
		Assert.assertNotNull(conditions.getSearchBar());
		Util.highLighterMethod(driver, conditions.getSearchBar());
		conditions.setSearchBar(search);
		Assert.assertNotNull(conditions.getLinkEchoSupport());
		Util.highLighterMethod(driver, conditions.getLinkEchoSupport());
		conditions.clickEchoSupport();
	}

	@Then("^elements should be displayed$")
	public void elements_should_be_displayed() {
		AEchoSupport echoSupport = new AEchoSupport(driver);
		echoSupport.scrollDown(0, 600);

		Assert.assertNotNull(echoSupport.getHDGettingStarted());
		Util.highLighterMethod(driver, echoSupport.getHDGettingStarted());

		Assert.assertNotNull(echoSupport.getHDWifiBluetooth());
		Util.highLighterMethod(driver, echoSupport.getHDWifiBluetooth());

		Assert.assertNotNull(echoSupport.getHDDeviceSoftware());
		Util.highLighterMethod(driver, echoSupport.getHDDeviceSoftware());

		Assert.assertNotNull(echoSupport.getHDThrobleshooting());
		Util.highLighterMethod(driver, echoSupport.getHDThrobleshooting());

		Assert.assertNotNull(echoSupport.getHDLearnMore());
		Util.highLighterMethod(driver, echoSupport.getHDLearnMore());

	}
}