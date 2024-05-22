package agi.qa.aromatru.tests;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import agi.qa.aromatru.base.BaseTest;
import agi.qa.aromatru.constants.AppConstants;
import agi.qa.aromatru.utils.ExcelUtil;

public class AromaTruOrderFlowTest extends BaseTest {

	@BeforeClass()
	public void affilatePageSetup() throws InterruptedException {

		// atruPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		// setup();
		// atruPage = loginPage.clickShopNow();

	}

	@DataProvider
	public Object[][] getDataFromExcel() {
		return ExcelUtil.getTestData(AppConstants.PRODUCT_SHEET_NAME);
	}

	@Test(dataProvider = "getDataFromExcel")
	public void placeOrder(ITestContext testContext, String urllink, String ModelName,
			String FreeProducts, String WifiDiffuser, String CoverforFirstDiffuser, String SecondDiffuser,String CoverforSecondDiffuser, String RushShipping,
			String email, String firstname, String lastname, String addone, String addtwo, String cty, String state,
			String zipcode, String phonenumber, String subtotal, String flatrate, String tax, String finaltotal)
			throws InterruptedException, Exception {
		try {
			loginPage.closeSignUpPopUp();
			atruPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
			softAssert = new SoftAssert();
			int currenttest = atruPage.testMe(testContext);
			Thread.sleep(5000);
			atruPage.clickjoinNow();
			System.out.println(WifiDiffuser+CoverforFirstDiffuser+SecondDiffuser+CoverforSecondDiffuser+RushShipping);
			//atruPage.selectModel(ModelName, UpgradeWithFreeTrial, UpgradeWithoutFreeTrial);
			Thread.sleep(8000);
			atruPage.checkout(email, firstname, lastname, addone, addtwo, cty, state, zipcode, phonenumber);
			Thread.sleep(15000);
			atruPage.SelectUpsell(WifiDiffuser, CoverforFirstDiffuser, SecondDiffuser ,CoverforSecondDiffuser,RushShipping);
			Map<String, String> productActDetailsMap = atruPage.getorderdetails();
			softAssert.assertEquals(productActDetailsMap.get("subtotal"), subtotal);
			System.out.println(
					"Expected Subtotal: " + subtotal + " Actual Subtotal: " + productActDetailsMap.get("subtotal"));
			softAssert.assertEquals(productActDetailsMap.get("Shipping"), flatrate);
			System.out.println(
					"Expected Shipping: " + flatrate + " Actual Shipping: " + productActDetailsMap.get("Shipping"));
			softAssert.assertEquals(productActDetailsMap.get("tax"), tax);
			System.out.println("Expected tax: " + tax + " Actual tax: " + productActDetailsMap.get("tax"));
			softAssert.assertEquals(productActDetailsMap.get("total"), finaltotal);
			System.out.println("Expected total: " + finaltotal + " Actual total: " + productActDetailsMap.get("total"));
			atruPage.writeexcel(productActDetailsMap.get("subtotal"), productActDetailsMap.get("Shipping"),
					productActDetailsMap.get("tax"), productActDetailsMap.get("total"),
					productActDetailsMap.get("OrderID"), currenttest);
			softAssert.assertAll();

		} finally {
			// Close and Open the browser
			tearDown();
			setup();
		}

	}
}
