package com.stepdefenition;

import org.testng.Assert;
import com.pagemanager.PageObjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TC1_LoginStep {

	PageObjectManager pom = new PageObjectManager();
	
	@Given("I am on the login page")
	public void iAmOnTheLoginPage() {
	
	}

	@When("I enter username {string} and password {string}")
	public void iEnterUsernameAndPassword(String username, String password) {
		pom.getLoginPages().login(username, password);
	}

	@When("I click the login button")
	public void iClickTheLoginButton() {
		pom.getLoginPages().clickLogin();
	}

	@Then("I should verify after login success message {string}")
	public void iShouldVerifyAfterLoginSuccessMessage(String expLoginSuccessMsg) {
		Assert.assertEquals(expLoginSuccessMsg, pom.getLoginPages().succMsg());	
	}

	@Then("I should verify the error message {string}")
	public void iShouldVerifyTheErrorMessage(String expecErrorMsg) {
		Assert.assertEquals(expecErrorMsg, pom.getLoginPages().errorMsg());
		
	}
}
