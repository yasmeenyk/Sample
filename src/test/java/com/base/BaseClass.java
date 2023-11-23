package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.ElementState;
import com.microsoft.playwright.options.LoadState;

public class BaseClass {
	public static Playwright playwright;
	public static Browser browser;
	public static BrowserContext browserContext;
	public static Page page;
	public static Properties prop;
	public static ElementHandle element;
	private static final String CONFIG_FILE_PATH = "C:\\Users\\yimaam\\eclipse-workspace\\PW\\src\\test\\resources\\config.properties";

	public static Page initBrowser(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		playwright = Playwright.create();
		try {
			switch (browserName.toLowerCase()) {
			case "chromium":
				browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
				break;
			case "firefox":
				browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
				break;
			case "safari":
				browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
				break;

			default:
				System.out.println("Enter Valid browser name");
				break;
			}
			browserContext = browser.newContext();
			page = browserContext.newPage();

			return page;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to send " + browserName);

		}
	}

	public static String getHomepageTitle() {
		try {
			String title = page.title();	
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("faild to get HomePage URL");
 
		}
		return null;
		
	}

	public static String getHomepageURL() {
		String url = page.url();
		return url;
	}

	public static void navigateTo(String url) {
		page.navigate(url);
	}

	public static ElementHandle findByQuery(String selector) {
		ElementHandle querySelector = page.querySelector(selector);
		return querySelector;

	}

	public static void fillInput(ElementHandle element, String text) {
		try {
			element.fill(text);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clkElement(ElementHandle element) {
		try {
			element.click();
			page.waitForLoadState(LoadState.NETWORKIDLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public static Frame contentFrame(String frameName) {
		return page.frame(frameName);

	}

	public static Frame mainFrame() {
		return page.mainFrame();

	}

	public static String innerText(String selector) {
		ElementHandle element = page.querySelector(selector);
		return element.innerText();

	}

	public static String innerHTML(String selector) {
		ElementHandle element = page.querySelector(selector);
		return element.innerHTML();

	}

	public static String inputValue(String selector) {
		ElementHandle element = page.querySelector(selector);
		return element.inputValue();

	}

	public boolean isChecked(String selector) {
		ElementHandle element = page.querySelector(selector);
		return element.isChecked();
	}

	public boolean isDisabled(String selector) {
		ElementHandle element = page.querySelector(selector);
		return element.isDisabled();
	}

	public boolean isEnabled(String selector) {
		ElementHandle element = page.querySelector(selector);
		return element.isEnabled();
	}

	public boolean isEditable(String selector) {
		ElementHandle element = page.querySelector(selector);
		return element.isEditable();
	}

	public boolean isVisible(String selector) {
		ElementHandle element = page.querySelector(selector);
		return element.isVisible();
	}

	public boolean isHidden(String selector) {
		ElementHandle element = page.querySelector(selector);
		return element.isHidden();
	}

	public static void hoverOver(String selector) {
		ElementHandle element = page.querySelector(selector);
	}

	public static void ddnOptions(String selector, String optionText) {
		ElementHandle element = page.querySelector(selector);
	}

	public static void closeBrowser() {
		page.context().browser().close();
		playwright.close();
	}

	public static void waitForElementToBeVisible(int milliseconds) {
		try {
			Thread.sleep(milliseconds);

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static void waitForElementToBeClickable(String selector) {
		ElementHandle element = page.querySelector(selector);
		element.waitForElementState(ElementState.ENABLED);
	}

	public static void waitForElementToBeVisible(String selector) {
		ElementHandle element = page.querySelector(selector);
		element.waitForElementState(ElementState.VISIBLE);
	}

	public static void waitForElementToBeHidden(String selector) {
		ElementHandle element = page.querySelector(selector);
		element.waitForElementState(ElementState.HIDDEN);
	}

	public static Properties init_prop() throws IOException {
		try {
			FileInputStream stream = new FileInputStream("src\\test\\resources\\Config\\Config.properties");
			prop = new Properties();
			prop.load(stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}

	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}
	
	public static String getAbsolutePath(String relativePath) {
		String path = System.getProperty("user.dir");
		return path+ File.separator+relativePath;
	}

 

	public static String getProperty(String key) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(getProjectPath()+"\\src\\test\\resources\\config.properties"));
		Object object = prop.get(key);
		String value = (String) object;
		return value;
	}

	
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(CONFIG_FILE_PATH));
		Object object = prop.get(key);
		String value = (String) object;
		return value;
	}

	public static String setPropertyFileValue(String key, String value) throws IOException {
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(
				getProjectPath() + "src\\test\\resources\\config.properties");
		prop.load(input);
		prop.setProperty(key, value);
		FileOutputStream output = new FileOutputStream(
				getProjectPath() + "src\\test\\resources\\config.properties");
		prop.store(output, "");
		output.close();
		return value;

	}

	public void deleteDataInPropertyFile(String key) {
		Properties prop = new Properties();
		prop.remove(key);
	}

	public void mouseHoverAction() {
		try {
			element.hover();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static byte[] screenshot() {

		byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));
		return screenshot;

	}

	public void toPassUrl(String url) {
		page.navigate(url);

	}

	public static Properties readProperties() {
		Properties prop = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH);
			prop.load(fileInputStream);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;
	}
	
    public void screenshot1() {
	    page.screenshot(new Page.ScreenshotOptions()
	    	.setPath(Paths.get("screenshot.png")));
	    }
}
