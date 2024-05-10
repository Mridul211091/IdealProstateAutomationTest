package agi.qa.idealprostate.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import agi.qa.idealprostate.base.BaseTest;
import agi.qa.idealprostate.constants.AppConstants;
import agi.qa.idealprostate.errors.AppError;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE, AppError.TITLE_NOT_FOUND);
	}

	@Test(priority = 2)
	public void loginIconLinkExistTest() {
		Assert.assertTrue(loginPage.isLoginIconExist());
	}

	@Test(priority = 3)
	public void loginTest() throws InterruptedException {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		//Assert.assertEquals(loginPage.getLoginSuccessText(), AppConstants.LOGIN_SUCCESS_TEXT);
	}
	


}
