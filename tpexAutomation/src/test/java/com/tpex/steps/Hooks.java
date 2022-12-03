package com.tpex.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.tpex.utilities.BrowserClass;
import com.tpex.utilities.DriverClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks extends DriverClass {

	@Before
	public void initDriver() {
		driver = new BrowserClass().openBrowser();
	}

	@After
	public void tearDown(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
		driver.quit();
	}
}
