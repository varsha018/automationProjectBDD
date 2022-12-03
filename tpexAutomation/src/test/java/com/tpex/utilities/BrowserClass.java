package com.tpex.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserClass extends DriverClass {
	
	private static String browser = "chrome";
	private static String chromeDriverShortRelativeResourcePath = "classpath:drivers";
	private static String chromeDriverResourceName = "chromedriver";
	private static String windowsChromeDriverResourceNameExtension = ".exe";
	private static String SYSTEM_PROPERTY_OSNAME = "os.name";
	private static String SYSTEM_PROPERTY_WEBDRIVER_CHROME = "webdriver.chrome.driver";
	private static String CHROME_ARGS = new StringBuilder("--headless").append(",").append("--disable-gpu").append(",")
			.append("--window-size=1920, 1200").append(",").append("--ignore-certificate-errors").toString();
	
	String projectPath = System.getProperty("user.dir");
	String exePath = "/src/test/resources/drivers/chromedriver.exe";
	
	String os = System.getProperty(SYSTEM_PROPERTY_OSNAME).toLowerCase();
	
	public WebDriver openBrowser() {
		System.out.println(os);
		if(browser.equalsIgnoreCase("chrome")) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.setHeadless(false);

		System.setProperty("webdriver.chrome.driver", projectPath + exePath);
		
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.manage().window().setSize(new Dimension(1900, 1200));
		}
		else 
			if(browser.equalsIgnoreCase("edge")) {
		}
		
		return driver;
	
	}
}
