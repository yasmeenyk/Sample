package com.stepdefenition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import com.base.BaseClass;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass{
	static Scenario sc;
	@Before
	public void beforeScenario(Scenario scenario) throws FileNotFoundException, IOException {
		System.out.println("Scenario Name is: "+ scenario.getName());
		System.out.println("Scenario Time is: "+ System.currentTimeMillis());
		Properties readProperties = readProperties();
		initBrowser(readProperties);
		navigateTo(getPropertyFileValue("url"));

	}
	@After
	public void afterScenario(Scenario scenario) {
		boolean failed = scenario.isFailed();
		if(failed) {
			scenario.attach(screenshot(), getHomepageURL(), getHomepageTitle());
//		 Page.screenshot(new page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));
		}
	}
}