package agi.qa.idealprostate.pages;

import java.sql.Time;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import agi.qa.idealprostate.constants.AppConstants;
import agi.qa.idealprostate.utils.ElementUtil;
import agi.qa.idealprostate.utils.TimeUtil;

public class LoginPage {

	// Page class/Page Library/Page Object
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. Private By Locators
	private By loginIcon = By.xpath("//i[@class='icon-user']");
	private By tryItNow = By.className("order-now");
	private By shopNow = By.xpath(
			"//*[@id=\"masthead\"]/div/div[4]/ul/li[7]/div/a");
	private By usernameField = By.id("username");
	private By passwordField = By.id("password");
	private By loginButton = By.name("login");
	private By loginText = By.xpath("//div[text()='You are successfully logged in!']");
	private By buynowbtn = By.xpath("(//a[normalize-space()='Buy Now'])[1]");
	private By shopnowbtn = By.xpath("//*[@id=\"masthead\"]/div/div[4]/ul/li[7]/div/a");
	private By cookiebannerbtn = By.cssSelector("div > div > div.dg-main-actions > button.dg-button.accept_all");
	//private By backtohomepage = By.xpath("//*[@id='logo']/a");
	private By backtohomepage = By.xpath("//a[contains(@href, 'idealprostate.in')]");
	private By cookie = By.cssSelector(".sc-dcJsrY.hNTnAz");
	private By logout = By.xpath("//*[@id='main']/div[2]/div/div/div[2]/div/div/p[1]/a");
	private By shadowroot = By.xpath("//aside[@class='dg-consent-banner theme-neutral position-bottom visible']");

	// 2. Public Page Class Const...
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. Public Page Actions/Method
	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, TimeUtil.DEFAULT_MEDIUM_TIME);
		System.out.println("login page title : " + title);
		return title;
	}

	public IdealProstateOrderFlowPage getaffiliateURL(String url) {
		driver.get(url);
		return new IdealProstateOrderFlowPage(driver);
	}

	public String getLoginSuccessText() {
		eleUtil.waitForElementVisible(loginText, TimeUtil.DEFAULT_LONG_TIME);
		String title = eleUtil.doGetElementText(loginText);
		System.out.println("login success text : " + title);
		return title;
	}
	
	public IdealProstateOrderFlowPage clickTryNow() {
		eleUtil.waitForElementPresence(shopNow, TimeUtil.DEFAULT_LONG_TIME);
		eleUtil.doActionsClick(shopNow);
		eleUtil.waitForElementPresence(tryItNow, TimeUtil.DEFAULT_LONG_TIME);
		eleUtil.doActionsClick(tryItNow);
		return new IdealProstateOrderFlowPage(driver);
	}

	public String getLoginPageURL() {
		String url = eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION, TimeUtil.DEFAULT_MEDIUM_TIME);
		System.out.println("login page url : " + url);
		return url;
	}

	public boolean isLoginIconExist() {
		return eleUtil.isElementDisplayed(loginIcon);
	}

	public IdealProstateOrderFlowPage doLogin(String username, String pwd) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(shadowroot).getShadowRoot().findElement(cookiebannerbtn).click();
		Thread.sleep(2000);
		eleUtil.clickWhenReady(loginIcon, TimeUtil.DEFAULT_LONG_TIME);
		eleUtil.waitForElementVisible(usernameField, TimeUtil.DEFAULT_LONG_TIME);
		eleUtil.doSendKeys(usernameField, username);
		eleUtil.doSendKeys(passwordField, pwd);
		eleUtil.doClick(loginButton);
		Thread.sleep(3000);
		return new IdealProstateOrderFlowPage(driver);
	}

	public IdealProstateOrderFlowPage loginAgain(String username, String pwd) throws InterruptedException {
		Thread.sleep(2000);
		if (eleUtil.isElementExist(logout)) {
			eleUtil.clickWhenReady(logout, TimeUtil.DEFAULT_MEDIUM_TIME);
			eleUtil.clickWhenReady(backtohomepage, TimeUtil.DEFAULT_MEDIUM_TIME);
			eleUtil.clickWhenReady(loginIcon, TimeUtil.DEFAULT_LONG_TIME);
			eleUtil.waitForElementVisible(usernameField, TimeUtil.DEFAULT_LONG_TIME);
			eleUtil.doSendKeys(usernameField, username);
			eleUtil.doSendKeys(passwordField, pwd);
			eleUtil.doClick(loginButton);
			eleUtil.doClick(backtohomepage);
		} else {
			eleUtil.clickWhenReady(backtohomepage, TimeUtil.DEFAULT_MEDIUM_TIME);
			eleUtil.clickWhenReady(loginIcon, TimeUtil.DEFAULT_LONG_TIME);
			eleUtil.waitForElementVisible(usernameField, TimeUtil.DEFAULT_LONG_TIME);
			eleUtil.doSendKeys(usernameField, username);
			eleUtil.doSendKeys(passwordField, pwd);
			eleUtil.doClick(loginButton);
			eleUtil.doClick(backtohomepage);
		}
		return new IdealProstateOrderFlowPage(driver);
	}


	public IdealProstateOrderFlowPage clickShopNow() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(shadowroot).getShadowRoot().findElement(cookiebannerbtn).click();
		Thread.sleep(5000);
		eleUtil.clickWhenReady(shopnowbtn, TimeUtil.DEFAULT_LONG_TIME);
		Thread.sleep(5000);
		eleUtil.waitForElementPresence(tryItNow, TimeUtil.DEFAULT_LONG_TIME);
		eleUtil.doActionsClick(tryItNow);
		return new IdealProstateOrderFlowPage(driver);

	}

}
