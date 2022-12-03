package com.tpex.runner;

import org.testng.annotations.AfterClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/features",
glue = { "com.tpex.steps" },
plugin = { "pretty",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
monochrome = true,
publish = true,
tags = "@SmokeTest"

)

public class Runner extends AbstractTestNGCucumberTests {
	
	@AfterClass
	public static void writeExtentReport() {
//		Reporter.log(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
//		Reporter.log("User Name", System.getProperty("user.name"));
//	    Reporter.log("Time Zone", System.getProperty("user.timezone"));
//	    Reporter.log("Machine", 	"Windows 10" + "64 Bit");
//	    Reporter.log("Selenium", "4.6.0");
//	    Reporter.log("Maven", "3.5.2");
//	    Reporter.log("Java Version", "11");
	}
	
}
