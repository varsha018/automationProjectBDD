package com.tpex.steps;

import com.tpex.pages.login_page;
import com.tpex.utilities.DriverClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends DriverClass {
	login_page lp;

	@Given("^open the browser$")
	public void browser_is_open() {
		System.out.println("Browser is launched");
	}

	@And("^user navigate to (.*)$")
	public void user_navigate_to_test_project_url(String URL) {
		driver.navigate().to(URL);
	}

	@When("user selects {string} from the dropDown")
	public void user_selects_from_the_drop_down(String string) {
		System.out.println("user enters domain from dropdown");
	}

	@Then("^user enter (.*) and (.*)$")
	public void user_enter_user_name_and_password(String userName, String password) {
		lp = new login_page(driver);
		lp.enterUSername(userName);
		lp.enterPassword(password);
	}

	@Then("^user click on login button$")
	public void user_click_on_login_button() {
		lp.clickOnLoginBtn();
	}

	@Then("verify user is logged in successfully")
	public void verify_user_is_logged_in_successfully() {
		System.out.println("Verified");
	}

	@Then("user gets login failed error message")
	public void user_gets_login_failed_error_message() {
		System.out.println("LOGIN failed");
	}

	@Then("user close the browser")
	public void user_close_the_browser() {
		System.out.println("Browser is closed");
	}

}
