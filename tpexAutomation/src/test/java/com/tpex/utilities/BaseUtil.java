package com.tpex.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.log4testng.Logger;

public class BaseUtil extends DriverClass {

	Duration duration;

	WebDriverWait wait = new WebDriverWait(driver, duration);
	private static Logger log = Logger.getLogger(BaseUtil.class);

	/*
	 * This method is used to move to element on the page.
	 */
	public WebElement moveToElement(By by) throws Exception {
		WebElement element = driver.findElement(by);
		moveToElement(element);
		return element;
	}

	public WebElement moveToElement(WebElement element) throws Exception {
		try {
			// sleep(500);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-100);window.scrollBy(-75,0);", element);
		} catch (Exception e) {
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
		}
		return element;
	}


	/*
	 * Click Enter on Any Element through Keys.Return
	 */
	public void clickEnterOnElement(WebElement element) throws Exception {
		moveToElement(element);
		try {
			click(element);
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
		element.sendKeys(Keys.RETURN);
	}

	/*
	 * This method clicks on element without move instruction.
	 */
	public void clickElementWithoutMove(WebElement element) throws Exception {
		try {
			click(element);
		} catch (Exception e) {
			throwsException("Unable to click Element : " + element);
		}
	}

	public void clickElementByJS(WebElement element) throws Exception {
		boolean isElementClickable = false;
		for (int x = 0; x < 3; x++) {
			try {
				if (isElementClickable == false) {
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					isElementClickable = true;
				}
			} catch (Exception e) {
				Reporter.log(e.getMessage());
				isElementClickable = false;
			}
		}
		if (isElementClickable == false) {
			throwsException("Element not clickable : " + element);
		}
	}

	private void click(WebElement element) throws Exception {
		try {
			element.click();
		} catch (Exception e) {
			clickElementByJS(element);
		}
	}

	/*
	 * This method clicks on element Actions Class instruction.
	 */
	public void clickElementWithActions(WebElement element) throws Exception {
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(element).click(element).build().perform();
		} catch (Exception e) {
			throwsException("Unable to click Element : " + element);
		}
	}

	public void clickElement(By by) throws Exception {
		WebElement element = driver.findElement(by);
		clickElement(element);
	}

	public void clickElement(WebElement element) throws Exception {
		element = moveToElement(element);
		try {
			
			click(element);
		} catch (Exception e) {
			clickElementByJS(element);
		}
	}
	
	public void send_Keys(WebDriver driver, By by, String value) {
		WebElement element = driver.findElement(by);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		try {
			clear(element);
			element.sendKeys(value);
		} catch (Exception e) {
			cleanByJS(element);
		}
	}

	private void clear(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			cleanByJS(element);
		}
	}

	private void cleanByJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='';", element);
	}

	public void takeScreenshot() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmm");
		String screenShotName = "target/screenshot/" + dateFormat.format(GregorianCalendar.getInstance().getTime());
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(String.format("%s.png", screenShotName)));
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void validateURL(String expectedUrl) {
		String actualURL = driver.getCurrentUrl();
		Assert.assertTrue(actualURL.equals(expectedUrl), "Expected URL is not matched with actual URL. Expected URL is: " + expectedUrl
				+ " and actaul URL is: " + actualURL);
	}

	public void validateTitle(String expectedTitle) throws InterruptedException {
		Thread.sleep(5000);
		String actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.equals(expectedTitle), "Expected Title is not matched with actual Title. Expected Title is: " + expectedTitle
				+ " and actaul Title is: " + actualTitle);
		log.info("User verified the title name is " + expectedTitle);
	}
	
	public String throwsException(String exceptionMsg) throws Exception {
		Reporter.log("");
		throw new Exception(exceptionMsg);
	}

}
