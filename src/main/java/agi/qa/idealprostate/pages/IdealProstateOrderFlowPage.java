package agi.qa.idealprostate.pages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;

import agi.qa.idealprostate.constants.AppConstants;
import agi.qa.idealprostate.utils.ElementUtil;
import agi.qa.idealprostate.utils.ExcelUtil;
import agi.qa.idealprostate.utils.JavaScriptUtil;
import agi.qa.idealprostate.utils.TimeUtil;

public class IdealProstateOrderFlowPage {

	// Page class/Page Library/Page Object
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil JsUtil;
	private Map<String, String> productMap = new HashMap<String, String>();

	// 1. Private By Locators

	private By logoutLink = By.linkText("Logout");
	private By shopNow = By.xpath(
			"//*[@id=\"masthead\"]/div/div[4]/ul/li[7]/div/a");
	private By tryItNow = By.className("order-now");
	private By upgradeWithFreeTrialbtn = By.id("buy_now");
	private By upgradeWithFreeTrialNoThanksbtn = By.id("no_thanks");
	private By upgradeWithoutFreeTrialbtn = By.id("buy_now");
	private By upgradeWithoutFreeTrialNoThanksbtn = By.id("no_thanks");
	private By buyUpsell = By.xpath(
			"//a[normalize-space()='ADD TO PURCHASE']");
	private By cancelUpsell = By.xpath(
			"//a[normalize-space()='NO THANKS']");
	private By cancelNewUltMaxUpsell = By.xpath(
			"//*[@id=\"content\"]/div/div/div/section[2]/div/div/div[2]/div/div/p[2]/a");
	private By cancelPerfectOmegaUpsell = By.xpath(
			"//*[@id=\"content\"]/section[2]/div/div/div[2]/div/div/p[2]/a");
	private By declineRushShipping = By.xpath(
			"//*[@id=\"content\"]/div/div/div/section[3]/div/div/div[2]/div/div/p/a");
	private By addRushShipping = By.xpath(
			"//a[normalize-space()='RUSH MY PURCHASE']");
	private By UltMaxText = By.xpath(
			"//h1[normalize-space()='ULTmax']");
	private By NewUltMaxText = By.xpath(
			"//h1[@class='wp-block-heading']");
	private By PerfectOmegaText = By.xpath(
			"//h1[normalize-space()='Perfect Omega']");
	private By RushShippingText = By.xpath(
			"//h1[normalize-space()='Rush Shipping & Processing']");
	
	//*[@id="content"]/div/div/div/section[2]/div/div/div[2]/div/div/p[2]/a"}
	
	
	
	
	
	
	
	
	
	private By bannerText = By.xpath("//strong[contains(text(),'NEW! AirDoctor 2500 Wall-Mounted Purifier Sale-on-')]");
	// private By bannerText =By.xpath("//ul[contains(@class,'nav header-bottom-nav
	// nav-center mobile-nav')]/li/p");
	// private By Model2500Text =By.xpath("//h5[normalize-space()='\"WALL-MOUNTED OR
	// FLOOR STANDING AIR PURIFIER\"']");
	// private By Model2500Text = By.xpath("//div[@class='product_text-inner-col
	// mob-hide-heading']/h3[span[@class='orange_new' and text()='New!
	// ']][text()='AirDoctor 2500']");
	private By Model2500Text = By.xpath(
			"//div[@class='product_text-inner-col mob-hide-heading' and not(contains(@style, 'display: none'))]/h3[1][contains(., 'AirDoctor 2500')]");
	// section[@class='section product-listing-section
	// product_section_130445']//div[2]//div[1]//h3[1]
	private By counterTopCarafeBtn = By.xpath(
			"//span[a[contains(text(), 'Carafe Countertop Reverse Osmosis Water Purifier')]]/ancestor::div[contains(@class, 'home-product-col')]/descendant::input[@id='121318']");
	private By counterTopCarafeAlkalineBtn = By.xpath(
			"//span[a[contains(text(), 'Carafe Countertop Reverse Osmosis Water Purifier')]]/ancestor::div[contains(@class, 'home-product-col')]/descendant::input[@id='121319']");
	private By countertopCarafePrice = By.xpath(
			"//input[@id='121318']/ancestor::div[contains(@class, 'home-product-col-inner')]//span[@class='main-price prc_prd_121317']/span[@class='woocommerce-Price-amount amount']/bdi");
	private By coutertopCarafeAddToCartBtn = By.xpath(
			"//span[contains(a/text(), 'Carafe Countertop Reverse Osmosis Water Purifier')]/ancestor::div[contains(@class, 'home-product-col-inner')]//a[contains(@class, 'cart_prd')]");
	private By preCheckoutSlidingTrayUpsellAddToCartBtn = By.xpath(
			"//div[contains(@class, 'prod-slider-name') and text()='AquaTru Carafe Countertop Sliding Tray']/following-sibling::div[@class='add-to-cart-btn']//a[contains(@class, 'product_add_cart')]");
	private By preCheckoutWarrantyUpsellAddToCartBtn = By.xpath(
			"//div[contains(@class, 'prod-slider-name') and text()='AquaTru Carafe 3-Yr Warranty']/following-sibling::div[@class='add-to-cart-btn']//a[contains(@class, 'product_add_cart')]");
	private By preCheckoutClassicSlidingTrayUpsellAddToCartBtn = By.xpath(
			"//div[contains(@class, 'prod-slider-name') and text()='AquaTru Countertop Sliding Tray']/following-sibling::div[@class='add-to-cart-btn']//a[contains(@class, 'product_add_cart')]");
	private By preCheckoutOneYearComboUpsellAddToCartBtn = By.xpath(
			"//div[contains(@class, 'prod-slider-name') and text()='Carafe ONLY One-Year Filter Combo Pack']/following-sibling::div[@class='add-to-cart-btn']//a[contains(@class, 'product_add_cart')]");
	private By checkoutBtn = By.xpath("//a[normalize-space()='Checkout']");
	private By classicCountertopRadioBtn = By.xpath("//label[.='Classic']/preceding-sibling::input[@type='radio']");
	private By classicAlkalineCountertopRadioBtn = By
			.xpath("/label[.='Classic, Alkaline']/preceding-sibling::input[@type='radio']");
	private By connectCountertopRadioBtn = By.xpath("//label[.='Connect']/preceding-sibling::input[@type='radio']");
	private By connectAlkalineCountertopRadioBtn = By
			.xpath("//label[.='Connect, Alkaline']/preceding-sibling::input[@type='radio']");
	private By classicCoutertopAddToCartBtn = By
			.xpath("//a[@data-product_id='14958' and normalize-space(.)='Add to cart']");
	private By preCheckoutClassicWarrantyUpsellAddToCartBtn = By.xpath(
			"//div[contains(@class, 'prod-slider-name') and text()='3 Year Extended Warranty - Classic']/following-sibling::div[@class='add-to-cart-btn']//a[contains(@class, 'product_add_cart')]");
	private By preCheckoutClassicOneYearComboUpsellAddToCartBtn = By.xpath(
			"//div[contains(@class, 'prod-slider-name') and text()='Classic One-Year Filter Combo Pack']/following-sibling::div[@class='add-to-cart-btn']//a[contains(@class, 'product_add_cart')]");
	private By preCheckoutClassicAlkalineOneYearComboUpsellAddToCartBtn = By.xpath(
			"//div[contains(@class, 'prod-slider-name') and text()='Classic One-Year Mineral Boost Alkaline Combo Filter Pack']/following-sibling::div[@class='add-to-cart-btn']//a[contains(@class, 'product_add_cart')]");

	private By preCheckoutConnectWarrantyUpsellAddToCartBtn = By.xpath(
			"//div[contains(@class, 'prod-slider-name') and text()='3 Year Extended Warranty - Connect']/following-sibling::div[@class='add-to-cart-btn']//a[contains(@class, 'product_add_cart')]");
	private By Model2000plusQuantityBtn = By.xpath(
			"//h3[contains(text(), 'AirDoctor 2000')]/following::input[@class='ux-quantity__button ux-quantity__button--plus button plus is-form'][1]");
	private By myAccountLink = By.linkText("My Account");
	private By headers = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	private By select7in1Model = By.xpath("//a[normalize-space()='7-in-1-saw model']");
	private By onePay = By.xpath("//*[@id=\'wc-option-pay-full\']");
	private By onePay7in1 = By.xpath("//*[@id='product-2155']/div/div[1]/div/div[2]/form/div/div[2]/ul[1]/li[2]/label");
	private By threePay7in1 = By
			.xpath("//*[@id='product-2155']/div/div[1]/div/div[2]/form/div/div[2]/ul[1]/li[1]/label");
	private By select3000Model = By.xpath("(//a[normalize-space()='platinum 3000 model'])[1]");
	private By noThanks = By.xpath("//*[@id=\"no_thanks\"]");
	private By firstName = By.id("billing_first_name");
	private By emailField = By.id("billing_email");
	private By lastName = By.id("billing_last_name");
	private By addressone = By.id("billing_address_1");
	private By addresstwo = By.id("billing_address_2");
	private By city = By.id("billing_city");
	private By zipcode = By.id("billing_postcode");
	private By phone = By.id("billing_phone");
	private By dropdownBtn = By.xpath("//*[@id=\"billing_state_field\"]/span/span/span[1]/span/span[2]");
	private By stateDropdown = By.id("select2-billing_state-container");
	private By statetextfield = By.cssSelector("input[role='combobox']");
	private By stateoption = By.cssSelector("#select2-billing_state-results:first-child li");
	private By termscheckbox = By.xpath("//input[@id='terms']");
	private By placeorderbtn = By.name("woocommerce_checkout_place_order");
	private By placeorderadbtn = By.id("place_order");
	private By popupdonebtn = By.id("wdc_popup");
	private By credicardradiobtn = By.id("payment_method_cybersource_credit_card");
	private By cardnumberfield = By.xpath("//input[@id='wc-authorize-net-cim-credit-card-account-number']");
	private By worldpaycardnumberfield = By.id("WC_Gateway_Worldpay-card-number");
	//input[@id='wc-authorize-net-cim-credit-card-payment-nonce']
	private By cardexpiryfield = By.id("wc-authorize-net-cim-credit-card-expiry");
	//input[@id='wc-authorize-net-cim-credit-card-expiry']
	private By worldpaycardexpiryfield = By.id("WC_Gateway_Worldpay-card-expiry");
	private By cardseccodefield = By.id("wc-authorize-net-cim-credit-card-csc");
	//input[@id='wc-authorize-net-cim-credit-card-csc']
	private By worldpaycardseccodefield = By.id("WC_Gateway_Worldpay-card-cvc");
	private By subtotalvalue = By.xpath("//th[text()='Subtotal:']/following-sibling::td");
	private By taxvalue = By.xpath("//th[text()='Tax:']/following-sibling::td");
	private By flatrate = By.xpath("//th[text()='Flat rate']/following-sibling::td");
	private By finaltotal = By.xpath("//th[text()='Total:']/following-sibling::td");
	private By ordernumber = By.xpath("//li[contains(text(), 'Order number')]/strong");
	//private By backtohomepage = By.xpath("//*[@id='logo']/a");
	private By backtohomepage = By.xpath("//a[contains(@href, 'idealprostate.in')]");
	private By logout = By.xpath("//*[@id='main']/div[2]/div/div/div[2]/div/div/p[1]/a");
	// *[@id="main"]/div[2]/div/div/div[2]/div/div/p[1]/a
	private By loginIcon = By.xpath("//a[@class='nav-top-link'][normalize-space()='Login']");
	private By usenewcard = By.id("wc-cybersource-credit-card-use-new-payment-method");
	private By paymentmethodtab = By.xpath("//*[@id=\"my-account-nav\"]/li[5]/a");
	private By logouttab = By.xpath("//*[@id='my-account-nav']/li[8]/a");
	private By deletebtn = By.xpath("//*[@id=\"main\"]/div[2]/div/div/div[2]/div/div/table/tbody/tr/td[6]/a[3]");

	// UnderSink Locators:
	private By undersinkAlkalineRadioBtn = By
			.xpath("//label[.='Alkaline ']/preceding-sibling::input[@type='radio' and @id='6135']");
	private By undersinkClassicRadioBtn = By
			.xpath("//label[.='Classic ']/preceding-sibling::input[@type='radio' and @id='6136']");
	private By undersinkAddToCartBtn = By.xpath("//a[@data-product_id='1714' and normalize-space(.)='Add to cart']");

	private By preCheckoutUnderSinkClassicWarrantyUpsellAddToCartBtn = By.xpath(
			"//div[contains(@class, 'prod-slider-name') and text()='3 Year Extended Warranty - Under Sink']/following-sibling::div[@class='add-to-cart-btn']//a[contains(@class, 'product_add_cart')]");
	private By preCheckoutUnderSinkClassicOneYearComboUpsellAddToCartBtn = By.xpath(
			"//div[contains(@class, 'prod-slider-name') and text()='Classic One-Year Filter Combo Pack']/following-sibling::div[@class='add-to-cart-btn']//a[contains(@class, 'product_add_cart')]");
	private By preCheckoutDeepBlueBottleUpsellAddToCartBtn = By.xpath(
			"//div[contains(@class, 'prod-slider-name') and text()='AquaTru Stainless Steel Water Bottle - Deep Blue']/following-sibling::div[@class='add-to-cart-btn']//a[contains(@class, 'product_add_cart')]");
	private By preCheckoutUrchinBlackBottleUpsellAddToCartBtn = By.xpath(
			"//div[contains(@class, 'prod-slider-name') and text()='AquaTru Stainless Steel Water Bottle - Urchin Black']/following-sibling::div[@class='add-to-cart-btn']//a[contains(@class, 'product_add_cart')]");
	private By preCheckoutWhiteSandBottleUpsellAddToCartBtn = By.xpath(
			"//div[contains(@class, 'prod-slider-name') and text()='AquaTru Stainless Steel Water Bottle - White Sand']/following-sibling::div[@class='add-to-cart-btn']//a[contains(@class, 'product_add_cart')]");

	// 2. Public Page Class Const...
	public IdealProstateOrderFlowPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		JsUtil = new JavaScriptUtil(driver);
	}

	public String getProductDisplayPageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.AD_AFFILIATE_PAGE_TITLE, 5);
		System.out.println("Landing page title : " + title);
		return title;
	}

	public String getPurifierPageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.AD_AFFILIATE_PURIFIER_PAGE_TITLE, 5);
		System.out.println("Prifier page title : " + title);
		return title;
	}

	public String getProductPageURL() {
		String url = eleUtil.waitForURLContains(AppConstants.PRODUCT_PAGE_URL_FRACTION, TimeUtil.DEFAULT_MEDIUM_TIME);
		System.out.println("product page url : " + url);
		return url;
	}

	public IdealProstateOrderFlowPage getaffiliateURL(String url) {
		driver.get(url);
		return new IdealProstateOrderFlowPage(driver);
	}

	public String getBannerText() {
		String title = eleUtil.doGetElementText(bannerText);
		System.out.println("Landing page banner text : " + title);
		return title;
	}

	public void clickShopNow() {
		eleUtil.waitForElementPresence(shopNow, TimeUtil.DEFAULT_LONG_TIME);
		eleUtil.doActionsClick(shopNow);
		eleUtil.waitForElementPresence(tryItNow, TimeUtil.DEFAULT_LONG_TIME);
		eleUtil.doActionsClick(tryItNow);
	}
	
	public void SelectUpsell(String Ultmax,String NewUltMax,String PerfectOmega, String RushShipping) throws InterruptedException {
		if(Ultmax.equalsIgnoreCase("Yes")&& eleUtil.isElementDisplayed(UltMaxText)) 
		{
			Thread.sleep(5000);
			System.out.println("Trying to Select Ultmax Upsell");
			eleUtil.doActionsClick(buyUpsell);
			System.out.println("Selected Ultmax Upsell ");
			//eleUtil.clickWhenReady(buyUpsell, TimeUtil.DEFAULT_LONG_TIME);
	}
	    if(Ultmax.equalsIgnoreCase("No")||Ultmax.equalsIgnoreCase("")&& eleUtil.isElementDisplayed(UltMaxText)) {
	    	Thread.sleep(5000);
	    	System.out.println("Trying to Cancel Ultmax Upsell");
	    	eleUtil.doActionsClick(cancelUpsell);
	    	System.out.println("Cancelled Ultmax Upsell ");
	    	Thread.sleep(5000);
	    	System.out.println(eleUtil.doGetElementText(NewUltMaxText));
	    	//eleUtil.clickWhenReady(cancelUpsell, TimeUtil.DEFAULT_LONG_TIME);
			}
		if(NewUltMax.equalsIgnoreCase("Yes")&& eleUtil.doGetElementText(NewUltMaxText).equals("New UL-T-Max. Sexual Performance Formula.\n"
				+ "Increases Total Testosterone.")) 
		{
			Thread.sleep(5000);
			System.out.println("Trying to Select NewUltmax Upsell");
			eleUtil.doActionsClick(buyUpsell);
			System.out.println("Selected NewUltmax Upsell Successfully ");
			//eleUtil.clickWhenReady(buyUpsell, TimeUtil.DEFAULT_LONG_TIME);
	}
		if(NewUltMax.equalsIgnoreCase("No")||NewUltMax.equalsIgnoreCase("")&& eleUtil.doGetElementText(NewUltMaxText).equals("New UL-T-Max. Sexual Performance Formula.\n"
				+ "Increases Total Testosterone.")) {
			Thread.sleep(5000);
			System.out.println("Trying to Cancel NewUltmax Upsell");
			eleUtil.doActionsClick(cancelNewUltMaxUpsell);
			System.out.println("Cancelled NewUltmax Upsell Successfully ");
			//eleUtil.clickWhenReady(cancelUpsell, TimeUtil.DEFAULT_LONG_TIME);
			}
		if(PerfectOmega.equalsIgnoreCase("Yes")&& eleUtil.isElementDisplayed(PerfectOmegaText)) 
		{
			Thread.sleep(5000);
			System.out.println("Trying to Select Perfect Omega Upsell");
			eleUtil.doActionsClick(buyUpsell);
			System.out.println("Selected Perfect Omega Upsell Succesfully");
			//eleUtil.clickWhenReady(buyUpsell, TimeUtil.DEFAULT_LONG_TIME);
	}
		if(PerfectOmega.equalsIgnoreCase("No")||PerfectOmega.equalsIgnoreCase("")&& eleUtil.isElementDisplayed(PerfectOmegaText)) {
			System.out.println("Trying to Cancel Perfect Omega Upsell");
			Thread.sleep(5000);
			eleUtil.doActionsClick(cancelPerfectOmegaUpsell);
			System.out.println("Cancelled Perfect Omega Upsell Succesfully");
			//eleUtil.clickWhenReady(cancelUpsell, TimeUtil.DEFAULT_LONG_TIME);
			}
		if(RushShipping.equalsIgnoreCase("Yes")&& eleUtil.isElementDisplayed(RushShippingText)) 
		{
			Thread.sleep(5000);
			System.out.println("Trying to Add Rush Shipping.");
			eleUtil.doActionsClick(addRushShipping);
			System.out.println("Added Rush Shipping Succesfully.");
			//eleUtil.clickWhenReady(addRushShipping, TimeUtil.DEFAULT_LONG_TIME);
	    }
		if(RushShipping.equalsIgnoreCase("No")||RushShipping.equalsIgnoreCase("") && eleUtil.isElementDisplayed(RushShippingText)) {
			Thread.sleep(5000);
			System.out.println("Trying to Decline Rush Shipping.");
			eleUtil.doActionsClick(declineRushShipping);
			System.out.println("Declined Rushshipping");
			//eleUtil.clickWhenReady(cancelUpsell, TimeUtil.DEFAULT_LONG_TIME);
			}
		else {
			System.out.println("Pass Correct Values in Excel");
		}
		}

	public String getModelText() {
		String title = eleUtil.doGetElementText(Model2500Text);
		System.out.println("Model Text is : " + title);
		return title;
	}

	public Map<String, String> getorderdetails() throws InvalidFormatException, IOException {
		System.out.println("=====================================================");
		productMap.put("subtotal", eleUtil.getElement(subtotalvalue).getText());
		productMap.put("tax", eleUtil.getElement(taxvalue).getText());
		productMap.put("Shipping", eleUtil.getElement(flatrate).getText());
		productMap.put("total", eleUtil.getElement(finaltotal).getText());
		productMap.put("OrderID", eleUtil.getElement(ordernumber).getText());
		System.out.println("product Details: \n" + productMap);
		return productMap;
	}

	public void checkout(String email, String firstname, String lastname, String addone, String addtwo, String cty,
			String state, String zip, String phonenumber) throws InterruptedException, Exception {
		Thread.sleep(5000);
		eleUtil.doSendKeys(emailField, email);
		eleUtil.doSendKeys(firstName, firstname);
		eleUtil.doSendKeys(firstName, firstname);
		eleUtil.doSendKeys(lastName, lastname);
		eleUtil.doSendKeys(addressone, addone);
		eleUtil.doSendKeys(addresstwo, addtwo);
		eleUtil.doSendKeys(city, cty);
		//JsUtil.scrollIntoView(eleUtil.getElement(dropdownBtn));
		eleUtil.clickWhenReady(dropdownBtn, TimeUtil.DEFAULT_MEDIUM_TIME);
		eleUtil.doSendKeys(statetextfield, state);
		eleUtil.clickWhenReady(stateoption, TimeUtil.DEFAULT_MEDIUM_TIME);
		eleUtil.SendKeys(zipcode, zip);
		eleUtil.doSendKeys(phone, phonenumber);
		//JsUtil.scrollIntoView(eleUtil.getElement(cardnumberfield));
		Thread.sleep(3000);
		//eleUtil.SendKeys(cardnumberfield, AppConstants.CARD_NUMBER);
		//eleUtil.doActionsSendKeys(cardnumberfield, AppConstants.CARD_NUMBER);
		//eleUtil.SendKeys(cardexpiryfield, AppConstants.CARD_EXPIRY);
		//eleUtil.doActionsSendKeys(cardexpiryfield, AppConstants.CARD_EXPIRY);
		//JsUtil.scrollIntoView(eleUtil.getElement(placeorderbtn));
		Thread.sleep(3000);
		//eleUtil.SendKeys(cardseccodefield, AppConstants.SECURITY_CODE);
		//eleUtil.doActionsSendKeys(cardseccodefield, AppConstants.SECURITY_CODE);
		//JsUtil.scrollIntoView(eleUtil.getElement(placeorderbtn));
		Thread.sleep(2000);
		eleUtil.doActionsClick(termscheckbox);
		// eleUtil.doClickcheckbox(termscheckbox,TimeUtil.DEFAULT_MEDIUM_TIME);
		Thread.sleep(2000);
		eleUtil.doActionsClick(placeorderadbtn);
		eleUtil.clickWhenReady(popupdonebtn, TimeUtil.DEFAULT_MEDIUM_TIME);
		eleUtil.waitForElementVisible(UltMaxText, TimeUtil.MAX_TIME);
		System.out.println("=====================================================");
	}

	public void selectModel(String ModelName, String UpgradeWithFreeTrial, String UpgradeWithoutFreeTrial) throws InterruptedException, Exception {
		try {
			if (ModelName.equals("Ideal Prostate") && UpgradeWithFreeTrial.equalsIgnoreCase("Yes")) {
				System.out.println("=====================================================");
				Thread.sleep(5000);
				System.out.println("Trying to Upgrade with Free Trial");
				eleUtil.doActionsClick(upgradeWithFreeTrialbtn);
				System.out.println("Successfully Upgraded with Free Trial");
				Thread.sleep(5000);
				System.out.println("=====================================================");
			}

			else if (ModelName.equals("Ideal Prostate") && UpgradeWithoutFreeTrial.equalsIgnoreCase("Yes")) {
				System.out.println("=====================================================");
				Thread.sleep(5000);
				System.out.println("Trying to Upgrade with Full Payment");
				eleUtil.doActionsClick(upgradeWithFreeTrialNoThanksbtn);
				Thread.sleep(10000);
				eleUtil.doActionsClick(upgradeWithoutFreeTrialbtn);
				System.out.println("Upgraded with Full Payment");
				Thread.sleep(5000);
				System.out.println("=====================================================");
			} 
			
			else if (ModelName.equals("Ideal Prostate")) {
				//JsUtil.scrollIntoView(eleUtil.getElement(upgradeWithFreeTrialNoThanksbtn));
				System.out.println("=====================================================");
				System.out.println("Trying to Place Order with Free Trial without any Upgrade");
				Thread.sleep(5000);
				eleUtil.doActionsClick(upgradeWithFreeTrialNoThanksbtn);
				Thread.sleep(10000);
				//JsUtil.scrollIntoView(eleUtil.getElement(upgradeWithoutFreeTrialNoThanksbtn));
				eleUtil.doActionsClick(upgradeWithoutFreeTrialNoThanksbtn);
				Thread.sleep(5000);
				System.out.println("Moved to Checkout Page with Free Trial without any Upgrade");
				System.out.println("=====================================================");
			} 
			

			else {
				System.out.println("Incorrect Model");
				// Fail - Incorrect payment option
			}
		}

		catch (Exception ex) {
			System.out.println("Check Model Name");
			throw ex;

		}

	}

	public void writeexcel(String subtotal, String flatrate, String tax, String total,String orderId, int count)
			throws InvalidFormatException, IOException {
		ExcelUtil.setdata(AppConstants.PRODUCT_SHEET_NAME, subtotal, flatrate, tax, total, orderId, count);
	}

	public int testMe(ITestContext testContext) {
		int currentCount = testContext.getAllTestMethods()[0].getCurrentInvocationCount();
		System.out.println("Executing count: " + currentCount);
		return currentCount;
	}
	
	public LoginPage navigateToHomePage() {
		eleUtil.clickWhenReady(backtohomepage, TimeUtil.DEFAULT_MEDIUM_TIME);
		System.out.println("Navigated back to Home Page");
		return new LoginPage(driver);
	}

	public LoginPage logoutfromthankyoupage() throws InterruptedException {
		eleUtil.clickWhenReady(backtohomepage, TimeUtil.DEFAULT_MEDIUM_TIME);
		eleUtil.clickWhenReady(loginIcon, TimeUtil.DEFAULT_MEDIUM_TIME);
		//JsUtil.scrollIntoView(eleUtil.getElement(logouttab))
		Thread.sleep(3000);
		eleUtil.clickWhenReady(logout, TimeUtil.DEFAULT_MEDIUM_TIME);
		return new LoginPage(driver);
	}

}
